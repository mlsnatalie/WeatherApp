package com.example.menglingshuai.weatherapp

import android.app.Dialog
import io.reactivex.FlowableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * Created by zhangliang on 2018/5/5.
 */
object RxHelper {

    fun <T> applyIOScheduler(): FlowableTransformer<T, T> {
        return FlowableTransformer { flowable ->
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyIOSchedulerToSingle(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyComputationScheduler(): FlowableTransformer<T, T> {
        return FlowableTransformer { flowable ->
            flowable.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyLoading(loading: Dialog): FlowableTransformer<T, T> {
        return FlowableTransformer { flowable ->
            flowable.doOnSubscribe { loading.show() }
                    .doFinally { loading.dismiss() }
        }
    }

    fun <T> applyLoadingToSingle(loading: Dialog): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single.doOnSubscribe { loading.show() }
                    .doFinally { loading.dismiss() }
        }
    }
}