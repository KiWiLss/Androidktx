package com.kiwilss.lxkj.xktx.test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lss kiwilss
 * @FileName: JsonTest
 * @e-mail : kiwilss@163.com
 * @time : 2019-09-08
 * @desc : {DESCRIPTION}
 */
public class JsonTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key","value");
        String json = JSON.toJSONString(map);
        System.out.println(json);
        //List<String> strings = JSON.parseArray(json, String.class);
        Map map1 = JSON.parseObject(json, Map.class);
        //System.out.println(strings);
        System.out.println(map1);
    }
}
