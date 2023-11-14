package com.example.myhappyplants.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhappyplants.domain.Plant
import com.example.myhappyplants.domain.PlantsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: PlantsRepository) :
    ViewModel() {
    private var _plantsData = MutableLiveData<List<Plant>?>(null)
    val plantsData: LiveData<List<Plant>?> get() = _plantsData

    private var _loadingState = MutableLiveData<Boolean>(false)
    val loadingState: LiveData<Boolean> get() = _loadingState

    fun loadPlants(page: Int) {
        viewModelScope.launch {
            _loadingState.postValue(true)
            _plantsData.postValue(repository.getPlants(page))
            _loadingState.postValue(false)
        }
    }
}