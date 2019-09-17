/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BannerPresenter
 * Author:   kiwilss
 * Date:     2019-09-17 14:55
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.mvpdemo.ui.banner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kiwilss.lxkj.basemvp.base.BasePresenter
import com.kiwilss.lxkj.basemvp.bean.HomeBanner
import com.kiwilss.lxkj.basemvp.http.RetrofitHelper

/**
 *@FileName: BannerPresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
class BannerPresenter : BasePresenter(){

    val dataResult = MutableLiveData<List<HomeBanner>>()

    fun getData(){
        handlerResult {
            val response = RetrofitHelper.apiService.getBanner()
            executeResponse(response){
                dataResult.value = response.data
            }
        }
    }

}

class Banner: ViewModel(){

}