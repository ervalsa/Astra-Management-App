package com.astra.astramotormangement.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astra.astramotormangement.data.response.login.LoginResponse
import com.astra.astramotormangement.data.retrofit.ApiConfig
import com.astra.astramotormangement.data.Result
import com.astra.astramotormangement.data.response.login.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> = _loginResult

    fun login(username: String, password: String) {
        _isLoading.value = true

        val loginRequest = LoginRequest(username, password)
        val client = ApiConfig.getApiService().login(loginRequest)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                _isLoading.value = false

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _loginResult.value = Result.Success(responseBody)
                    }
                } else {
                    Log.e("LoginViewModel", "onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _isLoading.value = false
                _loginResult.value = Result.Error(t.message.toString())
                Log.e("LoginViewModel", "onFailure : ${t.message.toString()}")
            }
        })
    }
}