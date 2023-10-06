package com.dhananjaysaini.weather.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhananjaysaini.weather.Model.City
import com.dhananjaysaini.weather.Repository.WeatherRepository
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")                                       // use - asFlow
class WeatherViewModel
@ViewModelInject
constructor(private val weatherRepository: WeatherRepository): ViewModel() {

    val getData:MutableLiveData<City> = MutableLiveData()
    val searchCity = ConflatedBroadcastChannel<String>()

    fun getSearchData(city:String){
        searchCity.trySend(city).isSuccess
    }

    @OptIn(ObsoleteCoroutinesApi::class)                          //use - as Flow
    fun getCityData() = viewModelScope.launch {
        searchCity.asFlow()                                      // two terms are defined above
            .flatMapLatest {
                city->
                weatherRepository.getCityData(city)
            }.catch { e->
                Log.d("main", "getCityData:")
            }.collect { city->
                getData.value= city
            }
    }

}

annotation class ViewModelInject
