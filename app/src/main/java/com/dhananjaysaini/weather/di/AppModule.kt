package com.dhananjaysaini.weather.di

//import dagger.hilt.android.components.ApplicationComponent

import com.dhananjaysaini.weather.Network.ApiService
import com.dhananjaysaini.weather.Network.GET
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import javax.inject.Singleton


@Module
@InstallIn(AppModule.ApplicationComponent::class)
class AppModule {
    object ApplicationComponent {

    }

    @Provides
    fun providesBaseUrl(): String = "https://api.openweathermap.org/geo/1.0/"

    @Provides
    @Singleton

        fun providesRetrofitBuilder(baseUrl: String): Retrofit {
            val build = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return build
        }


    @Provides
        fun providesApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

    }












