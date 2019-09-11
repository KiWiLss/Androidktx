package com.kiwilss.lxkj.xktx

import com.alibaba.fastjson.JSON
import org.junit.Assert.assertEquals
import org.junit.Test




/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testJson(){

        val map = HashMap<String,String>()
        map.put("key", "value")
        println(map)
        val json = JSON.toJSONString(map)
        println(json)
        val string = JSON.parseArray(json, String::class.java)
        println(string)
        val map1 = JSON.parseObject(json, HashMap::class.java)
        println(map1)


//        val map = hashMapOf<String,String>()
//        map["key1"] = "value1"
//        map["key2"] = "value2"
//        println(map)
//        val json = map.toString()
//        println(json)
//        val map3 = JSON.parseObject(json,HashMap::class.java)
//        println(map3)

//        val json2 =JSON.toJSON(map)
//        println(json2)
//        println(json2.toString().toAny<HashMap<String,String>>())
//        val jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}"
//
//        val map2 = jsonString.toAny<HashMap<String,String>>()
//        println(map2)
    }
}
