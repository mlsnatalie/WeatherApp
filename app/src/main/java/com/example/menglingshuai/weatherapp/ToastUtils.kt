package com.example.menglingshuai.weatherapp

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.view.ViewCompat
import android.support.v4.widget.TextViewCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**
 *
 * Created by zhangliang on 2018/5/7.
 * 参考 http://blankj.com
 *
 */
object ToastUtils {

    private val COLOR_DEFAULT = -0x1000001
    private val HANDLER = Handler(Looper.getMainLooper())

    private var sToast: Toast? = null
    private var gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
    private var xOffset = 0
    private var yOffset = (64 * UtilsSetting.getApplication().resources.displayMetrics.density + 0.5).toInt()
    private var bgColor = COLOR_DEFAULT
    private var bgResource = -1
    private var msgColor = COLOR_DEFAULT

    /**
     * 设置吐司位置
     *
     * @param gravity 位置
     * @param xOffset x 偏移
     * @param yOffset y 偏移
     */
    fun setGravity(gravity: Int, xOffset: Int, yOffset: Int) {
        ToastUtils.gravity = gravity
        ToastUtils.xOffset = xOffset
        ToastUtils.yOffset = yOffset
    }

    /**
     * 设置背景颜色
     *
     * @param backgroundColor 背景色
     */
    fun setBgColor(@ColorInt backgroundColor: Int) {
        ToastUtils.bgColor = backgroundColor
    }

    /**
     * 设置背景资源
     *
     * @param bgResource 背景资源
     */
    fun setBgResource(@DrawableRes bgResource: Int) {
        ToastUtils.bgResource = bgResource
    }

    /**
     * 设置消息颜色
     *
     * @param msgColor 颜色
     */
    fun setMsgColor(@ColorInt msgColor: Int) {
        ToastUtils.msgColor = msgColor
    }

    fun showShort(text: CharSequence) {
        show(text, Toast.LENGTH_SHORT)
    }

    fun showShort(@StringRes resId: Int) {
        show(resId, Toast.LENGTH_SHORT)
    }

    fun showLong(text: CharSequence) {
        show(text, Toast.LENGTH_LONG)
    }

    fun showLong(@StringRes resId: Int) {
        show(resId, Toast.LENGTH_LONG)
    }

    /**
     * 安全地显示短时自定义吐司
     */
    fun showCustomShort(@LayoutRes layoutId: Int): View? {
        val view = getView(layoutId)
        show(view, Toast.LENGTH_SHORT)
        return view
    }

    /**
     * 安全地显示长时自定义吐司
     */
    fun showCustomLong(@LayoutRes layoutId: Int): View? {
        val view = getView(layoutId)
        show(view, Toast.LENGTH_LONG)
        return view
    }

    /**
     * 取消吐司显示
     */
    fun cancel() {
        if (sToast != null) {
            sToast?.cancel()
            sToast = null
        }
    }

    private fun show(@StringRes resId: Int, duration: Int) {
        show(UtilsSetting.getApplication().resources.getText(resId), duration)
    }

    private fun show(text: CharSequence, duration: Int) {
        HANDLER.post(Runnable {
            cancel()
            sToast = Toast.makeText(UtilsSetting.getApplication(), text, duration)
            // solve the font of toast
            val tvMessage = sToast!!.view!!.findViewById<TextView>(android.R.id.message)
            TextViewCompat.setTextAppearance(tvMessage, android.R.style.TextAppearance)
            tvMessage.setTextColor(msgColor)
            sToast!!.setGravity(gravity, xOffset, yOffset)
            setBg(tvMessage)
            sToast!!.show()
        })
    }

    private fun show(view: View?, duration: Int) {
        HANDLER.post(Runnable {
            cancel()
            sToast = Toast(UtilsSetting.getApplication())
            sToast!!.setView(view)
            sToast!!.setDuration(duration)
            sToast!!.setGravity(gravity, xOffset, yOffset)
            setBg()
            sToast!!.show()
        })
    }

    private fun setBg() {
        if (sToast == null) {
            return
        }
        val toastView = sToast!!.getView()
        if (bgResource != -1) {
            toastView.setBackgroundResource(bgResource)
        } else if (bgColor != COLOR_DEFAULT) {
            val background = toastView.getBackground()
            if (background != null) {
                background.colorFilter = PorterDuffColorFilter(bgColor, PorterDuff.Mode.SRC_IN)
            } else {
                ViewCompat.setBackground(toastView, ColorDrawable(bgColor))
            }
        }
    }

    private fun setBg(tvMsg: TextView) {
        val toastView = sToast!!.view
        if (bgResource != -1) {
            toastView.setBackgroundResource(bgResource)
            tvMsg.setBackgroundColor(Color.TRANSPARENT)
        } else if (bgColor != COLOR_DEFAULT) {
            val tvBg = toastView.getBackground()
            val msgBg = tvMsg.background
            if (tvBg != null && msgBg != null) {
                tvBg.colorFilter = PorterDuffColorFilter(bgColor, PorterDuff.Mode.SRC_IN)
                tvMsg.setBackgroundColor(Color.TRANSPARENT)
            } else if (tvBg != null) {
                tvBg.colorFilter = PorterDuffColorFilter(bgColor, PorterDuff.Mode.SRC_IN)
            } else if (msgBg != null) {
                msgBg.colorFilter = PorterDuffColorFilter(bgColor, PorterDuff.Mode.SRC_IN)
            } else {
                toastView.setBackgroundColor(bgColor)
            }
        }
    }

    private fun getView(@LayoutRes layoutId: Int): View? {
        val inflate = UtilsSetting.getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflate.inflate(layoutId, null)
    }

}