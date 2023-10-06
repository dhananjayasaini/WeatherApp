package com.dhananjaysaini.weather.Network

import android.security.identity.AccessControlProfileId
import com.dhananjaysaini.weather.Model.City

class ApiServiceImp  constructor(private val apiService: ApiService) {

    suspend fun getCityData(city:String, appid:String):City = apiService.getCityData(city, appid)

}