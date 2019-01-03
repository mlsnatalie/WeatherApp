package com.example.menglingshuai.weatherapp

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Created by zhangliang on 2018/5/5.
 */
object CdamService {

    val api: CdamApi by lazy {

        //        val parameterInterceptor= CommonParamsInterceptor()

        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(parameterInterceptor)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .build()
        return@lazy retrofit.create(CdamApi::class.java)
    }

    private val API_BASE_URL =
        "http://api.openweathermap.org/data/2.5/forecast/"

    private fun addParameters(builder: HttpUrl.Builder, params: Map<String, String>): HttpUrl.Builder {
        for ((key, value) in params) {
            builder.addQueryParameter(key, value)
        }
        return builder
    }

    private fun getToken(): String {

        return "81b78ff7-b7c6-4b43-b1da-7f738af5dd36"
    }


}