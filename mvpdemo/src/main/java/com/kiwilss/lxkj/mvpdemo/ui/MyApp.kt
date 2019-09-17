/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyApp
 * Author:   kiwilss
 * Date:     2019-09-17 14:52
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.mvpdemo.ui

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.coder.zzq.smartshow.core.SmartShow
import com.jeremyliao.liveeventbus.LiveEventBus
import com.kiwilss.lxkj.basemvp.BaseConfig
import com.kiwilss.lxkj.xktx.AndroidKtxConfig
import kotlin.properties.Delegates

/**
 *@FileName: MyApp
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
class MyApp : Application(){

    companion object {
        var context: Context by Delegates.notNull()

        lateinit var instance: MyApp
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        instance = this

        initOther()
    }

    private fun initOther() {
        AndroidKtxConfig.init(this)
        BaseConfig.init(this)
        Utils.init(this)
        LogUtils.getConfig().setLogSwitch(true).globalTag = "MMM"
        //toast,topbar,snackbar初始化
        SmartShow.init(this)
        //livedatabus
        LiveEventBus.get()
            .config()
            .supportBroadcast(this)
            .lifecycleObserverAlwaysActive(true)
            .autoClear(false)
    }
}