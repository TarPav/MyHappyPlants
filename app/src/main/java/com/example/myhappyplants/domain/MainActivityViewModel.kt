package com.example.myhappyplants.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhappyplants.data.PlantsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: PlantsRepository) :
    ViewModel() {
    private var _plantsData = MutableLiveData<List<PlantsModel>?>(null)
    val plantsData: LiveData<List<PlantsModel>?> get() = _plantsData

    private var _loadingState = MutableLiveData<Boolean>(false)
    val loadingState: LiveData<Boolean> get() = _loadingState

    fun loadPlants(amount: Int, page: Int) {
        viewModelScope.launch {
            _loadingState.value = true

            val response = repository.getPlants(amount, page)
            if (response.isSuccessful) {
                _plantsData.value = response.body()
                _loadingState.value = false

            } else {
                _plantsData.value = null
                _loadingState.value = false

            }
        }

    }
}