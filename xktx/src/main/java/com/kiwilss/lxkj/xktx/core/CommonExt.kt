package com.kiwilss.lxkj.xktx.core


import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.*
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.io.Serializable


/**
 * Description:  通用扩展
 * Create by dance, at 2018/12/5
 */

/** dp和px转换 **/
fun Context.dp2px(dpValue: Float): Int {
    return (dpValue * resources.displayMetrics.density + 0.5f).toInt()
}

fun Context.px2dp(pxValue: Float): Int {
    return (pxValue / resources.displayMetrics.density + 0.5f).toInt()
}

fun Context.sp2px(spValue: Float): Int {
    return (spValue * resources.displayMetrics.scaledDensity + 0.5f).toInt()
}

fun Context.px2sp(pxValue: Float): Int {
    return (pxValue / resources.displayMetrics.scaledDensity + 0.5f).toInt()
}


fun Fragment.dp2px(dpValue: Float): Int {
    return context!!.dp2px(dpValue)
}

fun Fragment.px2dp(pxValue: Float): Int {
    return context!!.px2dp(pxValue)
}

fun Fragment.sp2px(dpValue: Float): Int {
    return context!!.sp2px(dpValue)
}

fun Fragment.px2sp(pxValue: Float): Int {
    return context!!.px2sp(pxValue)
}


fun View.px2dp(pxValue: Float): Int {
    return context!!.px2dp(pxValue)
}

fun View.dp2px(dpValue: Float): Int {
    return context!!.dp2px(dpValue)
}

fun View.sp2px(dpValue: Float): Int {
    return context!!.sp2px(dpValue)
}

fun View.px2sp(pxValue: Float): Int {
    return context!!.px2sp(pxValue)
}

//fun RecyclerView.ViewHolder.px2dp(pxValue: Float): Int {
//    return itemView.px2dp(pxValue)
//}
//
//fun RecyclerView.ViewHolder.dp2px(dpValue: Float): Int {
//    return itemView.dp2px(dpValue)
//}
//
//fun RecyclerView.ViewHolder.sp2px(dpValue: Float): Int {
//    return itemView.sp2px(dpValue)
//}
//
//fun RecyclerView.ViewHolder.px2sp(pxValue: Float): Int {
//    return itemView.px2sp(pxValue)
//}

/** 动态创建Drawable **/
fun Context.createDrawable(color: Int = Color.TRANSPARENT, radius: Float = 0f,
                           strokeColor: Int = Color.TRANSPARENT, strokeWidth: Int = 0,
                           enableRipple: Boolean = true,
                           rippleColor: Int = Color.parseColor("#88999999")): Drawable {
    val content = GradientDrawable().apply {
        setColor(color)
        cornerRadius = radius
        setStroke(strokeWidth, strokeColor)
    }
    if (Build.VERSION.SDK_INT >= 21 && enableRipple) {
        return RippleDrawable(ColorStateList.valueOf(rippleColor), content, null)
    }
    return content
}

fun Fragment.createDrawable(color: Int = Color.TRANSPARENT, radius: Float = 0f,
                            strokeColor: Int = Color.TRANSPARENT, strokeWidth: Int = 0,
                            enableRipple: Boolean = true,
                            rippleColor: Int = Color.parseColor("#88999999")): Drawable {
    return context!!.createDrawable(color, radius, strokeColor, strokeWidth, enableRipple, rippleColor)
}

fun View.createDrawable(color: Int = Color.TRANSPARENT, radius: Float = 0f,
                        strokeColor: Int = Color.TRANSPARENT, strokeWidth: Int = 0,
                        enableRipple: Boolean = true,
                        rippleColor: Int = Color.parseColor("#88999999")): Drawable {
    return context!!.createDrawable(color, radius, strokeColor, strokeWidth, enableRipple, rippleColor)
}

//fun RecyclerView.ViewHolder.createDrawable(color: Int = Color.TRANSPARENT, radius: Float = 0f,
//                                           strokeColor: Int = Color.TRANSPARENT, strokeWidth: Int = 0,
//                                           enableRipple: Boolean = true,
//                                           rippleColor: Int = Color.parseColor("#88999999")): Drawable {
//    return itemView.createDrawable(color, radius, strokeColor, strokeWidth, enableRipple, rippleColor)
//}


/** toast相关 **/
fun Context.toast(msg: CharSequence) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(msg: CharSequence) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun Fragment.toast(msg: CharSequence) {
    context?.toast(msg)
}

fun Fragment.longToast(msg: CharSequence) {
    context?.longToast(msg)
}

fun View.toast(msg: CharSequence) {
    context?.toast(msg)
}

fun View.longToast(msg: CharSequence) {
    context?.longToast(msg)
}


/** json相关 **/

//任意  数据转成 string 类型 (json)
fun Any.toJsonString(): String = JSON.toJSONString(this)

//json 数据转成任意对象
inline fun <reified T>String.toAny(): T = JSON.parseObject(this,T::class.java)

//json 类型转成 List<String>类型
fun String.toListString(): MutableList<String> = JSON.parseArray(this,String::class.java)

//json 类型转成 List<Any>类型
inline fun <reified T>String.toListAny() = JSON.parseArray(this,T::class.java)

//json 类型转成 List<Map>类型
fun String.toListMap(): List<Map<String, Any>> =
    JSON.parseObject(this, object : TypeReference<List<Map<String, Any>>>() {})

//任意类型转成 json 类型
fun Any.toJson(): String = Gson().toJson(this)

//json 类型转成任意类型
inline fun <reified T> String.toBean(): T = Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)


/** Window相关 **/
fun Context.windowWidth(): Int {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    return windowManager.defaultDisplay.width
}

fun Context.windowHeight(): Int {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    return windowManager.defaultDisplay.height
}

fun Fragment.windowWidth(): Int {
    return context!!.windowWidth()
}

fun Fragment.windowHeight(): Int {
    return context!!.windowHeight()
}

fun View.windowWidth(): Int {
    return context!!.windowWidth()
}

fun View.windowHeight(): Int {
    return context!!.windowHeight()
}

//fun RecyclerView.ViewHolder.windowWidth(): Int {
//    return itemView.windowWidth()
//}
//
//fun RecyclerView.ViewHolder.windowHeight(): Int {
//    return itemView.windowHeight()
//}


/** 网络相关 **/
/**
 * 当前网络是否有连接
 */
//fun Any.isNetworkConnected() = NetworkUtils.isConnected()
//
///**
// * 当前是否是Wifi连接
// */
//fun Any.isWifiConnected() = NetworkUtils.isWifiConnected()
//
///**
// * 当前是否是移动数据连接
// */
//fun Any.isMobileConnected() = NetworkUtils.isMobileData()


/**
 * 数组转bundle
 */
fun Array<out Pair<String, Any?>>.toBundle(): Bundle? {
    return Bundle().apply {
        forEach { it ->
            val value = it.second
            when (value) {
                null -> putSerializable(it.first, null as Serializable?)
                is Int -> putInt(it.first, value)
                is Long -> putLong(it.first, value)
                is CharSequence -> putCharSequence(it.first, value)
                is String -> putString(it.first, value)
                is Float -> putFloat(it.first, value)
                is Double -> putDouble(it.first, value)
                is Char -> putChar(it.first, value)
                is Short -> putShort(it.first, value)
                is Boolean -> putBoolean(it.first, value)
                is Serializable -> putSerializable(it.first, value)
                is Parcelable -> putParcelable(it.first, value)

                is IntArray -> putIntArray(it.first, value)
                is LongArray -> putLongArray(it.first, value)
                is FloatArray -> putFloatArray(it.first, value)
                is DoubleArray -> putDoubleArray(it.first, value)
                is CharArray -> putCharArray(it.first, value)
                is ShortArray -> putShortArray(it.first, value)
                is BooleanArray -> putBooleanArray(it.first, value)

                is Array<*> -> when {
                    value.isArrayOf<CharSequence>() -> putCharSequenceArray(it.first, value as Array<CharSequence>)
                    value.isArrayOf<String>() -> putStringArray(it.first, value as Array<String>)
                    value.isArrayOf<Parcelable>() -> putParcelableArray(it.first, value as Array<Parcelable>)
                }
            }
        }
    }

}


fun Any.runOnUIThread(action: ()->Unit){
    Handler(Looper.getMainLooper()).post { action() }
}

