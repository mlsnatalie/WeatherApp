package com.example.menglingshuai.weatherapp.helper.dialog

import android.content.Context
import android.view.ViewGroup
import com.example.menglingshuai.weatherapp.R


/**
 *
 * Created by zhangliang on 2018/5/7.
 */
object DialogHelper {

    fun loading(context: Context): android.app.AlertDialog {
        // 以后再优化，加载动画实践
        val builder = android.app.AlertDialog.Builder(context, R.style.Dialog_Loading)
        builder.setView(R.layout.view_loading)
                .setCancelable(true)
        val dialog = builder.create()
        dialog.window.setLayout(100, ViewGroup.LayoutParams.WRAP_CONTENT)
        return dialog
    }
}