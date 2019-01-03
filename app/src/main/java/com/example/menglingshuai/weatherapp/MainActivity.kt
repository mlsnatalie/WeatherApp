package com.example.menglingshuai.weatherapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.menglingshuai.weatherapp.domain.commands.model.CheckCouponItemModel
import com.example.menglingshuai.weatherapp.domain.commands.model.DataModel
import com.google.gson.Gson
import com.example.menglingshuai.weatherapp.helper.dialog.DialogHelper
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception

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

    private val mAdapter: ForecastListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = findViewById<RecyclerView>(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
        updateUI()
        initData()

//        forecastList.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = mAdapter
//            addItemDecoration( SimpleDividerDecoration(context))
//        }

//        loadCheckCouponList()

    }

    @SuppressLint("CheckResult")
    private fun loadCheckCouponList() {
        val loading = DialogHelper.loading(this)
        NetApi.getCheckCoupon("15646a06818f61f7b8d7823ca833e1ce", "94042")
            .compose(RxHelper.applyLoading(loading))
            .subscribe({ res ->
                if(res.data != null){
                    handleData(res.data)
                } else{
                    ToastUtils.showLong("没有优惠券")
                }
            }, { it ->
//                ToastUtils.showLong("${it.message}")
                Log.e("aaaddd", it.message)
            })
    }

    private fun handleData(list: List<CheckCouponItemModel>) {
        list.forEach {
            Log.e("aaaddd", it.dt)
        }
//        mAdapter.list_check_coupon.clear()
//        mAdapter.list_check_coupon.addAll(list)
//        mAdapter!!.notifyDataSetChanged()
    }

    private fun initData() {
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=15646a06818f61f7b8d7823ca833e1ce&zip=94042"
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
                    Log.e("aaaddd", mJson)
                    val gson = Gson()
                    val bean = gson.fromJson<DataModel>(mJson, DataModel::class.java)
                    Log.e("aaaddd", "6666" + bean.cod )
//                    val mList: List<DataModel.ListBean> = bean.list!!
                    Log.e("aaaddd", "22222" + bean.weather!!.size)
//                    Log.e("aaaddd", "7777" + mList.forEach{
//                        val list: List<DataModel.ListBean.WeatherBean> = it.weather!!
//                        it.pressure
//                        list.forEach {
//                            it.description
//                            Log.e("aaaddd", "1111" + it.description)
//                        }
//
//                    })
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



