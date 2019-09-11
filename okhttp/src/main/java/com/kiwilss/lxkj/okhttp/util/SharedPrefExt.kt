package com.kiwilss.lxkj.okhttp.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kiwilss.lxkj.okhttp.OkhttpConfig



/**
 * Description: SharedPreferences相关
 * Create by dance, at 2018/12/5
 */

fun Any.sp(name: String = OkhttpConfig.sharedPrefName) = OkhttpConfig.context.getSharedPreferences(name, Context.MODE_PRIVATE)

/**
 * 批处理
 */
fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
    edit().apply { action() }.apply()
}

/**
 * 对象操作
 */
fun SharedPreferences.putObject(key: String, obj: Any?) {
    putString(key, obj?.toJson()?:"")
}

inline fun <reified T> SharedPreferences.getObject(key: String): T? {
    val string = getString(key, null)
    if(string==null || string.isEmpty())return null
    return getString(key, null)?.toBean<T>()
}


/**
 *  put系列
 */
fun SharedPreferences.putString(key: String, value: String) {
    edit { putString(key, value) }
}

fun SharedPreferences.putInt(key: String, value: Int) {
    edit { putInt(key, value) }
}

fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    edit { putBoolean(key, value) }
}

fun SharedPreferences.putFloat(key: String, value: Float) {
    edit { putFloat(key, value) }
}

fun SharedPreferences.putLong(key: String, value: Long) {
    edit { putLong(key, value) }
}

fun SharedPreferences.putStringSet(key: String, value: Set<String>) {
    edit { putStringSet(key, value) }
}

fun SharedPreferences.remove(key: String){
    edit{ remove(key) }
}

fun SharedPreferences.clear() {
    edit { clear() }
}

//任意类型转成 json 类型
fun Any.toJson(): String = Gson().toJson(this)

//json 类型转成任意类型
inline fun <reified T> String.toBean(): T = Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)

