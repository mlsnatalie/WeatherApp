package com.example.menglingshuai.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.menglingshuai.weatherapp.date.ResponseClasses
import com.example.menglingshuai.weatherapp.domain.commands.model.ForecastList
import com.example.menglingshuai.weatherapp.domain.commands.model.dataModel
import com.google.gson.Gson
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = findViewById<RecyclerView>(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
//        updateUI()
        initData()

    }

    private fun initData() {
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7&APPID=15646a06818f61f7b8d7823ca833e1ce&zip=94042"
//        OkHttpUtils
//            .post()
//            .url(url)
//            .build()
//            .execute(MyStringCallback())

        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val mJson = response.body()!!.string()
                    val gson = Gson()
                    val bean = gson.fromJson<dataModel>(mJson, dataModel::class.java)

                    Log.e("aaaddd", "1111" + bean.dt )
//                    Log.e("aaaddd", "1111" + bean.city )
//                    Log.e("aaaddd", "1111" + bean.country )

                }
            }
        })


    }

    private fun updateUI() {
        forecastList.adapter = ForecastListAdapter(items)
    }

    inner class MyStringCallback : StringCallback() {
        override fun onResponse(response: String?, id: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onError(call: Call?, e: Exception?, id: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}



