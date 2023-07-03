package com.astra.astramotormangement.data.response.login

import com.astra.astramotormangement.data.response.login.LoginResult
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("loginResult")
    val loginResult: LoginResult
)