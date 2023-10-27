package com.example.myhappyplants.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhappyplants.data.PlantsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: PlantsRepository) : ViewModel() {
    private var _plantsData = MutableLiveData<List<PlantsModel>?>(null)
    val plantsData: LiveData<List<PlantsModel>?> get() = _plantsData

    fun loadPlants(
        amount: Int,
        page: Int,
    ) {
        repository.getPlants(
            amount,
            page,
        ).enqueue(
            object : Callback<List<PlantsModel>?> {
                override fun onResponse(
                    call: Call<List<PlantsModel>?>,
                    response: Response<List<PlantsModel>?>
                ) {
                    if (response.isSuccessful) {
                        _plantsData.postValue(response.body())

                    } else {
                        _plantsData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<PlantsModel>?>, t: Throwable) {
                    _plantsData.postValue(null)
                }

            }
        )
    }
}