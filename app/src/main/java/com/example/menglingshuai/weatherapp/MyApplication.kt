package com.example.menglingshuai.weatherapp

import android.app.Application
import com.zhy.http.okhttp.OkHttpUtils
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val okHttpClient = OkHttpClient.Builder()
            //                .addInterceptor(new LoggerInterceptor("TAG"))
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            //其他配置
            .build()

        OkHttpUtils.initClient(okHttpClient)
    }
}