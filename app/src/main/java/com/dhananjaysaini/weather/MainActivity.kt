package com.dhananjaysaini.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
//import androidx.activity.viewModels
import com.dhananjaysaini.weather.ViewModel.WeatherViewModel
import com.dhananjaysaini.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.net.URL
import java.nio.channels.AsynchronousByteChannel
import kotlin.properties.ReadOnlyProperty


private val ActivityMainBinding.searchView: Any
    get() {return true
    }


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val weatherViewModel: WeatherViewModel by viewModels()

    private fun viewModels(): ReadOnlyProperty<MainActivity, WeatherViewModel> {
        TODO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
        weatherViewModel.getCityData()
        weatherViewModel.getData.observe(this, { response ->
         if (response.weather.description == "clear sky" || response.weather.description == "mist") {
             Glide.with(this)
                 .load(R.drawable.haze)
                 .into(binding.image)
         }else
             if (response.weather.description == "rain") {
                 Glide.with(this)
                     .load(R.drawable.haze)
                     .into(binding.image)
             }else
                 if(response.weather.description == "rain"){
                     Glide.with(this)
                         .load(R.drawable.rain)
                         .into(binding.image)
                 }
            binding.description.text=response.weather.description
            //bindnig.name.text=response.name
            binding.speed.text=response.wind.speed.toString()
            binding.temp.text=response.main.temp.toString()
            binding.humidity.text=response.main.humidity.toString()
        })
    }

    private fun init()
    {
            binding.searchView.setOnQueryTextListener( object : androidx.appcompat.widget.SearchView.OnQueryTextListener ,
                android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextChange(p0: String?): Boolean {
                    val query = ""
                    query?.let {
                        val it = ""
                        weatherViewModel.getSearchData(it)
                    }
                    return true
                }

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }
            })

    }

    }

private fun Any.setOnQueryTextListener(onQueryTextListener: SearchView.OnQueryTextListener): Boolean {
    return true
}

