/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: OkhttpActivity
 * Author:   kiwilss
 * Date:     2019-09-09 10:47
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.androidktx.ui.okhttp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.lxkj.androidktx.R
import com.kiwilss.lxkj.okhttp.okhttp.HttpCallback
import com.kiwilss.lxkj.okhttp.okhttp.get
import com.kiwilss.lxkj.okhttp.okhttp.http
import com.kiwilss.lxkj.okhttp.util.logd
import com.kiwilss.lxkj.xktx.core.click
import kotlinx.android.synthetic.main.activity_okhttp.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 *@FileName: OkhttpActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-09
 * @desc   : {DESCRIPTION}
 */
class OkhttpActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        btn_okhttp_json.click {
            test2()
        }

    }

    fun test2(){
        val job = GlobalScope.launch (Dispatchers.Main){
            val response = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1".http()
                .get<String>().await()
            logd(response.toString())
            if (response.toString().isNotEmpty())
                tv_fg_home_text.text = response.toString()
//            runOnUiThread {
//                if (response.toString().isNotEmpty())
//                    tv_fg_home_text.text = response.toString()
//            }
        }

        //job.cancel()
    }



    fun test1(){
        "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1".http()
            .get(object :HttpCallback<String>{
                override fun onSuccess(t: String) {
                    runOnUiThread {
                        if (t.isNotEmpty())
                            tv_fg_home_text.text = t
                    }
                }

                override fun onFail(e: IOException) {
                    super.onFail(e)
                    runOnUiThread {
                        tv_fg_home_text.text = e.message
                    }
                }
            })
    }
}