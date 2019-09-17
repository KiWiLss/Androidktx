/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BaseConfig
 * Author:   kiwilss
 * Date:     2019-09-16 17:35
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.basemvp

import android.annotation.SuppressLint
import android.content.Context

/**
 *@FileName: BaseConfig
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-16
 * @desc   : {DESCRIPTION}
 */
@SuppressLint("StaticFieldLeak")
object BaseConfig {
    lateinit var context: Context

    fun init(context: Context
    ) {
        BaseConfig.context = context
    }
}