package com.example.pattern

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface Api {
    @GET("data/")
    suspend fun getUSData(
        @Query("drilldowns") drilldowns: String = "Nation",
        @Query("measures") measures: String = "Population"
    ): Response<USData>


    @GET("data/")
    fun getUSDataWithoutCorutine(
        @Query("drilldowns") drilldowns: String = "Nation",
        @Query("measures") measures: String = "Population"
    ): Call<USData>
}