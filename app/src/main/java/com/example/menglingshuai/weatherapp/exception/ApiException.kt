package com.example.menglingshuai.weatherapp.exception

import com.yintech.orderdemo.data.remote.ApiResponse


/**
 *
 * Created by zhangliang on 2018/5/5.
 */
open class ApiException(val code: String, message: String?) : Exception(message) {
    var data: Any? = null

    constructor(code: String, message: String?, data: Any?) : this(code, message) {
        this.data = data
    }

    constructor(apiResponse: ApiResponse<*>) : this(apiResponse.code, apiResponse.message, apiResponse.data)
}