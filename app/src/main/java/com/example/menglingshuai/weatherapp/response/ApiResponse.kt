package com.yintech.orderdemo.data.remote

import java.io.Serializable

/**
 *
 * Created by zhangliang on 2018/5/5.
 */
data class ApiResponse<out T>(val code: String,
                              val data: T?,
                              val message: String?,
                              val responseTime: Long) : Serializable