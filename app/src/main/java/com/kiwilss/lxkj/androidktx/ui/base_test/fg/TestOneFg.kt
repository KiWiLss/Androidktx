/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestOneFg
 * Author:   kiwilss
 * Date:     2019-09-17 11:33
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.androidktx.ui.base_test.fg

import android.os.Bundle
import android.view.View
import com.kiwilss.lxkj.androidktx.R
import com.kiwilss.lxkj.baseokhttp.base.BaseFragment

/**
 *@FileName: TestOneFg
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
class TestOneFg : BaseFragment<TestOneFgPresenter>() {
    override fun initPresenter(): TestOneFgPresenter = TestOneFgPresenter()

    override fun getLayoutId(): Int = R.layout.fg_test_one

    override fun initOnClick() {
    }

    override fun initData() {
    }

    override fun handlerSuccess() {
    }

    override fun initInterface(view: View, savedInstanceState: Bundle?) {
    }
}