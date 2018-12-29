package com.example.menglingshuai.weatherapp

import android.annotation.SuppressLint
import android.app.Application

@SuppressLint("StaticFieldLeak")
/**
 *
 * Created by zhangliang on 2018/5/5.
 */
object UtilsSetting {

    private var application: Application?= null

    fun getApplication(): Application {
        if(application != null) {
            return application!!
        } else {
            throw NullPointerException("application")
        }
    }

    fun init(application: Application) {
        this.application = application
    }
}