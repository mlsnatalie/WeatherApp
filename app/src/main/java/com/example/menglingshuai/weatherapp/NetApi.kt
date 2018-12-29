package com.example.menglingshuai.weatherapp

import com.example.menglingshuai.weatherapp.domain.commands.model.CheckCouponItemModel
import com.yintech.orderdemo.data.remote.ApiCode
import com.yintech.orderdemo.data.remote.ApiResponse
import com.example.menglingshuai.weatherapp.exception.ApiException
import com.example.menglingshuai.weatherapp.exception.ExceptionEngine
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer


/**
 *
 * Created by zhangliang on 2018/5/5.
 */
object NetApi {

    fun getCheckCoupon(APPID: String,zip: String): Flowable<ApiResponse<List<CheckCouponItemModel>?>> {

        val map: HashMap<String, String> = hashMapOf(Pair("APPID", APPID),Pair("zip", zip))
        return CdamService.api
                .getCheckCouponlist(map)
                .compose(apply())
    }

    private fun <T> apply(): FlowableTransformer<ApiResponse<T?>, ApiResponse<T?>> {
        return FlowableTransformer { flowable ->
            flowable.map { response ->
                if (ApiCode.SUCCESS.code != response.code ) {
                    // 业务异常
                    throw ApiException(response)
                }
                response

            }
                .doOnNext { res ->

                }
                .onErrorResumeNext { t: Throwable ->
                    // 非业务异常
                    Flowable.error(ExceptionEngine.handleException(t))

                }
                .compose(RxHelper.applyIOScheduler())
        }
    }
}