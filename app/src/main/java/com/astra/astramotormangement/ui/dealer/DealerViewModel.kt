package com.astra.astramotormangement.ui.dealer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astra.astramotormangement.data.response.dealer.DealerResponse
import com.astra.astramotormangement.data.Result
import com.astra.astramotormangement.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DealerViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _listDealer = MutableLiveData<Result<DealerResponse>>()
    val listDealer: LiveData<Result<DealerResponse>> = _listDealer

    fun dealers(dealerName: String) {
        _isLoading.value = true

        val client = ApiConfig.getApiService().getDealerByLocationName(dealerName)
        client.enqueue(object : Callback<DealerResponse> {
            override fun onResponse(
                call: Call<DealerResponse>,
                response: Response<DealerResponse>
            ) {
                _isLoading.value = false

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _listDealer.value = Result.Success(responseBody)
                    }
                } else {
                    Log.e("DealerViewModel", "onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DealerResponse>, t: Throwable) {
                _isLoading.value = false
                _listDealer.value = Result.Error(t.message.toString())
                Log.e("DealerViewModel", "onFailure: ${t.message.toString()}")
            }

        })
    }
}