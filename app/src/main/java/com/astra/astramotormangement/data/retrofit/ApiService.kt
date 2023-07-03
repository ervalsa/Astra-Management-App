package com.astra.astramotormangement.data.retrofit

import com.astra.astramotormangement.data.response.dealer.DealerResponse
import com.astra.astramotormangement.data.response.login.LoginRequest
import com.astra.astramotormangement.data.response.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("login")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Call<LoginResponse>

    @GET("dealer")
    fun getAllDealers() : Call<DealerResponse>

    @GET("dealer/{locationName}")
    fun getDealerByLocationName(
        @Path("locationName") locationName: String
    ) : Call<DealerResponse>

    // TODO: Make AddTask Function
    // TODO: Make UpdateTask Function
}