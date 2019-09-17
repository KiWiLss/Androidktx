/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestOnePresenter
 * Author:   kiwilss
 * Date:     2019-09-16 16:03
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.androidktx.ui.base_test

import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.kiwilss.lxkj.baseokhttp.base.BasePresenter
import com.kiwilss.lxkj.baseokhttp.bean.BaseBean
import com.kiwilss.lxkj.baseokhttp.bean.HomeBanner
import com.kiwilss.lxkj.okhttp.okhttp.get
import com.kiwilss.lxkj.okhttp.okhttp.http

/**
 *@FileName: TestOnePresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-16
 * @desc   : {DESCRIPTION}
 */
class TestOnePresenter : BasePresenter(){

    val test1 = MutableLiveData<List<HomeBanner>>()
     fun test1(){
//        presenterScope.launch {
////            handlerResult {
////                 RetrofitHelper.apiService.getBanner()
//////                executeResponse(response){
//////                    test1.value = response.data
//////                }
////                //response
////            }
//
//            val banner = RetrofitHelper.apiService.getBanner()
//            LogUtils.e(banner)
//        }

        handlerResult {
            val baseBean = "https://www.wanandroid.com/banner/json".http().get<BaseBean<List<HomeBanner>>>().await()
            Log.e("MMM", "presenter: $baseBean" );
            val data = baseBean?.data
            executeResponse(baseBean){
                test1.value = data
            }
//            val response = RetrofitHelper.apiService.getBanner()
//            LogUtils.e(response)
//                executeResponse(response){
//                    test1.value = response.data
//                }
        }

    }
}