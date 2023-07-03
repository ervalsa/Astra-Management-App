package com.astra.astramotormangement.data.response.dealer

import com.google.gson.annotations.SerializedName

data class DealerResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("listDealer")
    val listDealer: List<DealerItem>
)
