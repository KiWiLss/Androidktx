/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestOneActivity
 * Author:   kiwilss
 * Date:     2019-09-16 16:03
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.androidktx.ui.base_test

import android.os.Bundle
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.lxkj.androidktx.R
import com.kiwilss.lxkj.androidktx.ui.base_test.fg.TestOneFg
import com.kiwilss.lxkj.baseokhttp.base.BaseActivity
import com.kiwilss.lxkj.xktx.core.click
import com.kiwilss.lxkj.xktx.core.fragmentManager
import kotlinx.android.synthetic.main.activity_test_one.*

/**
 *@FileName: TestOneActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-16
 * @desc   : {DESCRIPTION}
 */
class TestOneActivity: BaseActivity<TestOnePresenter>() {
    override fun initPresenter(): TestOnePresenter = TestOnePresenter()


    override fun handlerSuccess() {
        mPresenter.test1.observe(this, Observer {
            LogUtils.e(it)
            dismissLoadingDiloag()
            it?.run {
                tv_test_info.text = this.toString()
            }
        })
    }

    override fun initData() {
    }

    override fun initOnClick() {
        btn_test_test1.click {
            showLoadingDiloag()
            mPresenter.test1()
        }
    }

    override fun initInterface(savedInstanceState: Bundle?) {

        //加入单个 fg

        val fg = TestOneFg()
        if (fg.isAdded) {
            fragmentManager { show(fg) }
        }else{
            fragmentManager {  add(R.id.fl_test_fl,fg) }
        }

    }

    override fun getLayoutId(): Int = R.layout.activity_test_one
}