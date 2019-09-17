/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyApp
 * Author:   kiwilss
 * Date:     2019-09-09 11:00
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.androidktx

import android.app.Application
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.kiwilss.lxkj.basemvp.BaseConfig
import com.kiwilss.lxkj.okhttp.OkhttpConfig
import com.kiwilss.lxkj.xktx.AndroidKtxConfig

/**
 *@FileName: MyApp
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-09
 * @desc   : {DESCRIPTION}
 */
class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()

        OkhttpConfig.init(this)
        AndroidKtxConfig.init(this)

        Utils.init(this)
        BaseConfig.init(this)
        LogUtils.getConfig().setLogSwitch(true).globalTag = "MMM"

    }
}