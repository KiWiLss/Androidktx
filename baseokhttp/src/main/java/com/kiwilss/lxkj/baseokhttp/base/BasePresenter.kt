/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BasePresenter
 * Author:   kiwilss
 * Date:     2019-09-16 15:35
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.baseokhttp.base

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kiwilss.lxkj.baseokhttp.bean.BaseBean
import kotlinx.coroutines.*

/**
 *@FileName: BasePresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-16
 * @desc   : {DESCRIPTION}
 */
abstract class BasePresenter {

    val mException: MutableLiveData<Exception> = MutableLiveData()

    val error = MutableLiveData<String>()

     val presenterScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Default + Job())
    }

    private var mContext: Context? =null

    fun attech(context: Context?){
        mContext = context
    }

    @ExperimentalCoroutinesApi
    fun detach() {
        mContext = null
        presenterScope.cancel()
    }

    private suspend fun <T : Any> apiCall(call: suspend () -> BaseBean<T>?): BaseBean<T>? {
        return call.invoke()
    }


    /**
     * 统一处理结果
     */
      fun <T : Any>handlerResult( api: suspend () -> BaseBean<T>?){
        presenterScope.launch {

//            val baseBean = api.invoke()
//            if (baseBean == null){
//                error.value = "未知异常"
//            }else{
//                LogUtils.e(baseBean.data)
//                if (isBean){
//
//                }else{
//
//                }
//            }


            try {
                val result = api.invoke()
                Log.e("MMM", "1111: $result");
                if (result == null){//
                    error.postValue("未知异常1")
                }
//                val baseBean = api.invoke()
//                LogUtils.e(baseBean)
            }catch (e: Exception){
                //LogUtils.e("MMM", ": $e")
                Log.e("MMM", "2222: $e" )
                mException.postValue(e)
                //不处理异常,只处理网络异常
//                if (NetworkUtils.isAvailableByPing()) {//网络可以用
                    error.postValue("未知异常")
//                }else{//网络不可用
//                    error.value = "网络异常"
//                }
            }
        }
    }

    suspend fun <T>executeResponse(response: BaseBean<T>?, isBean: Boolean = false,
                                   errorBlock:  suspend CoroutineScope.() -> Unit
                                   = { error.postValue(response?.errorMsg)   },
                                   beanBlock: suspend CoroutineScope.() -> Unit = {},
                                   successBlock:  suspend CoroutineScope.() -> Unit
    ): BaseBean<T>? {
        coroutineScope {
            if (response == null){
                errorBlock()
            }else{
                if (isBean){
                    beanBlock()
                }else{
                    if (response.errorCode == 0){
                        successBlock()
                    }else{
                        errorBlock()
                    }
                }
            }
//            if (isBean){
//                beanBlock()
//            }else{
//                if (response.errorCode == 0){
//                    successBlock()
//                }else{
//                    errorBlock()
//                }
//            }
        }
        return response
    }

}