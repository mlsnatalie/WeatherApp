package com.example.menglingshuai.weatherapp.exception

import android.net.ParseException
import com.example.menglingshuai.weatherapp.BuildConfig
import com.google.gson.JsonParseException
import com.yintech.orderdemo.data.remote.ApiCode
import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException


/**
 *
 * Created by zhangliang on 2018/5/5.
 */
object ExceptionEngine {

    //对应HTTP的状态码
    private val UNAUTHORIZED = 401
    private val FORBIDDEN = 403
    private val NOT_FOUND = 404
    private val REQUEST_TIMEOUT = 408
    private val INTERNAL_SERVER_ERROR = 500
    private val BAD_GATEWAY = 502
    private val SERVICE_UNAVAILABLE = 503
    private val GATEWAY_TIMEOUT = 504

    fun handleException(e: Throwable): ApiException {

        e.printStackTrace()

        if (e is ApiException) {
            return e
        }

        val apiCode: ApiCode = if (e is HttpException) {
            when (e.code()) {
                UNAUTHORIZED,
                FORBIDDEN,
                NOT_FOUND,
                REQUEST_TIMEOUT,
                GATEWAY_TIMEOUT,
                INTERNAL_SERVER_ERROR,
                BAD_GATEWAY,
                SERVICE_UNAVAILABLE -> ApiCode.ERROR_HTTP
                else -> ApiCode.ERROR_HTTP
            }
        } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException) {
            ApiCode.ERROR_PARSE
        } else if (e is SocketException
                || e is UnknownHostException) {
            ApiCode.ERROR_NETWORK
        } else {
            //修改success的状态，应该是 ERROR_UNKNOWN
            ApiCode.ERROR_UNKNOWN
        }

        if(BuildConfig.DEBUG) {
            e.printStackTrace()
        }

        return ApiException(apiCode.code, apiCode.description)
    }
}
