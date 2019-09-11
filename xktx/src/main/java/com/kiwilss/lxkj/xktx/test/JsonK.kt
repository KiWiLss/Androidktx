/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: JsonK
 * Author:   kiwilss
 * Date:     2019-09-08 22:14
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.xktx.test

/**
 *@FileName: JsonK
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-08
 * @desc   : {DESCRIPTION}
 */
fun main() {
        testJson()
}

fun testJson() {
    //map  <->  json
//    val map = hashMapOf<String, String>()
//    map["key1"] = "value1"
//    map["key2"] = "value2"
//    println(map)
//    //map -> json
//    println(map.toJsonString())
//    //json -> map
//    println(map.toJsonString().toAny<HashMap<String,String>>())

    // list <=> json
    val list = ArrayList<String>()
    list.add("1")
    list.add("2")
    list.add("3")
    list.filter {
        it.toInt() > 1
    }.forEach {
        println(it)
    }
    //list -> json
//    val json = list.toJsonString()
//    println(json)
//    //json -> list
//    println(json.toListString())

//    val json = list.toJson()
//    println(json)
//    val list2 = json.toBean<List<String>>()
//    println(list2)

}