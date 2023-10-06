package com.dhananjaysaini.weather.Network

import com.dhananjaysaini.weather.Model.City


interface ApiService {

    @GET()
    suspend fun getCityData(
        @Query("q") q:String,
        @Query("appid") appid:String
    ): City


}
annotation class GET()
annotation class Query(val value: String)


