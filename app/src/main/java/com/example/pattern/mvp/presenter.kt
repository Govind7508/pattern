package com.example.pattern.mvp

import com.example.pattern.RetrofitInstance
import com.example.pattern.USData
import retrofit2.Call
import retrofit2.Response
class Presenter(
    private val usDetailsInter: UsDetails,
    private val apiInter: RetrofitInstance
) {

        fun fetchData(drilldowns: String = "Nation", measures: String = "Population") {
            val call: Call<USData> = apiInter.api.getUSDataWithoutCorutine(drilldowns, measures)

            call.enqueue(object : retrofit2.Callback<USData> {
                override fun onResponse(call: Call<USData>, response: Response<USData>) {
                    response.body()?.let { usDetailsInter.showUsers(it) }

                }

                override fun onFailure(call: Call<USData>, t: Throwable) {
usDetailsInter.showError(t.message.toString())
                }
            })


        }




}
