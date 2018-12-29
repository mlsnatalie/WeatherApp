package com.example.menglingshuai.weatherapp


import com.example.menglingshuai.weatherapp.domain.commands.model.CheckCouponItemModel
import com.yintech.orderdemo.data.remote.ApiResponse
import io.reactivex.Flowable
import retrofit2.http.*

/**
 *
 * Created by zhangliang on 2018/5/5.
 */
interface CdamApi {

    @POST()
    fun getCheckCouponlist(@Body loginRequest: Map<String, String>
    ): Flowable<ApiResponse<List<CheckCouponItemModel>?>>
}



