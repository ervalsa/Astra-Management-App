package com.astra.astramotormangement.data.response.login

import com.google.gson.annotations.SerializedName

data class LoginResult(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("username")
    val username: String
)
