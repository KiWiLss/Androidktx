package com.kiwilss.lxkj.okhttp

import android.annotation.SuppressLint
import android.content.Context

/**
 * Description: 统一配置扩展方法中的变量
 * Create by lxj, at 2018/12/4
 */
@SuppressLint("StaticFieldLeak")
object OkhttpConfig {
    lateinit var context: Context
    var isDebug = true
    var defaultLogTag = "MMM"
    var sharedPrefName = "androidktx"

    /**
     * 初始化配置信息，必须调用
     * @param isDebug 是否是debug模式，默认为true
     */
    fun init(context: Context,
             isDebug: Boolean = true,
             defaultLogTag: String = OkhttpConfig.defaultLogTag,
             sharedPrefName: String = OkhttpConfig.sharedPrefName
    ) {
        OkhttpConfig.context = context
        OkhttpConfig.isDebug = isDebug
        OkhttpConfig.defaultLogTag = defaultLogTag
        OkhttpConfig.sharedPrefName = sharedPrefName
    }
}