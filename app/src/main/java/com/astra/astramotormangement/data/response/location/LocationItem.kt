package com.astra.astramotormangement.data.response.location

import com.google.gson.annotations.SerializedName

data class LocationItem(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String
)
