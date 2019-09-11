/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: LogExt
 * Author:   kiwilss
 * Date:     2019-09-08 23:03
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.okhttp.util

import android.util.Log
import com.kiwilss.lxkj.okhttp.OkhttpConfig

/**
 *@FileName: LogExt
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-08
 * @desc   : {DESCRIPTION}
 */
fun Any.logd(msg: String){
    if (OkhttpConfig.isDebug){
        Log.i(OkhttpConfig.defaultLogTag, msg)
    }
}

//针对网络请求,简化 url
fun String.map(map: Map<String,Any>): String{
    val sb = StringBuilder("$this?")
   map.forEach {
       sb.append(it.key + "=" + it.value + "&")
   }
    return sb.deleteCharAt(sb.lastIndex).toString()
}

fun String.param(vararg params: Pair<String, Any>): String{
    val sb = java.lang.StringBuilder("$this?")
    params.forEach {
        sb.append("${it.first}=${it.second}&")
    }
    return sb.deleteCharAt(sb.lastIndex).toString()
}

fun main() {//使用示例
    val url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1"
        .param("id" to 5,
            "key" to 7)
    println(url)
}