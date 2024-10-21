package com.example.pattern.mvc

import com.example.pattern.Api
import com.example.pattern.USData
import okhttp3.ResponseBody
import retrofit2.Response

class UserController(private val apiService: Api) {

    suspend fun fetchUsers(): Response<USData> {
        return try {
            apiService.getUSData("Nation","Population") // API call (Model interaction)
        } catch (e :Exception){
            Response.error<USData>(500, ResponseBody.create(null, "Error: ${e.message}"))

        }
    }
}