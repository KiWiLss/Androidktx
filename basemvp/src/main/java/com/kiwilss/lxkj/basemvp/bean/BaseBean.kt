package com.kiwilss.lxkj.basemvp.bean

import com.squareup.moshi.Json

data class BaseBean<T>(@Json(name = "data") val data: T,
                       @Json(name = "errorCode") val errorCode: Int,
                       @Json(name = "errorMsg") val errorMsg: String)



