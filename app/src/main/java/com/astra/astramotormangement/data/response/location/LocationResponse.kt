package com.astra.astramotormangement.data.response.location

import com.google.gson.annotations.SerializedName

data class LocationResponse (
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("listLocation")
    val listLocation: List<LocationItem>
)