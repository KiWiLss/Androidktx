/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: HomePresenter
 * Author:   kiwilss
 * Date:     2019-09-17 17:16
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.okhttpdemo.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kiwilss.lxkj.baseokhttp.base.BasePresenter
import com.kiwilss.lxkj.baseokhttp.bean.BaseBean
import com.kiwilss.lxkj.baseokhttp.bean.HomeBanner
import com.kiwilss.lxkj.okhttp.okhttp.get
import com.kiwilss.lxkj.okhttp.okhttp.http

/**
 *@FileName: HomePresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
class HomePresenter : BasePresenter(){

    val test1 = MutableLiveData<List<HomeBanner>>()
        fun get(){

//            presenterScope.launch {
//                val baseBean = "https://www.wanandroid.com/banner/json".http().get<BaseBean<List<HomeBanner>>>().await()
//                Log.e("MMM", "presenter: $baseBean" )
//            }

            handlerResult {
                val baseBean = "https://www.wanandroid.com/banner/json".http().get<BaseBean<List<HomeBanner>>>().await()
                Log.e("MMM", "presenter: $baseBean" )
                val data = baseBean?.data
                executeResponse(baseBean){
                    test1.postValue(data)
                }
            }
//
//
//            handlerResult()

//            GlobalScope.launch(Dispatchers.Default) {
//                                val baseBean = "https://www.wanandroid.com/banner/json".http()
//                                    .get<BaseBean<List<HomeBanner>>>().await()
//                Log.e("MMM", "presenter: $baseBean" )
//            }
        }



}