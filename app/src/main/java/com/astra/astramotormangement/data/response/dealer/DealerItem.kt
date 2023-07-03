package com.astra.astramotormangement.data.response.dealer

import com.google.gson.annotations.SerializedName

data class DealerItem(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("locationId")
    val locationId: String
)
