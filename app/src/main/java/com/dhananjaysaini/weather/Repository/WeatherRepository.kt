package com.dhananjaysaini.weather.Repository

//import androidx.constraintlayout.helper.widget.Flow
import com.dhananjaysaini.weather.Model.City
import com.dhananjaysaini.weather.Network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiServiceImp: ApiServiceImp){

    fun getCityData(city:String) : Flow<City> = flow {
      val response = apiServiceImp.getCityData(city, "be5f4524f6b7c6b6be3dc027a80494a8")
        emit(response)
    }.flowOn(Dispatchers.IO)
        .conflate()


}