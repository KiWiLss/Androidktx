/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: HomeActivity
 * Author:   kiwilss
 * Date:     2019-09-17 17:15
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.okhttpdemo.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.lxkj.baseokhttp.base.BaseActivity
import com.kiwilss.lxkj.okhttpdemo.R
import com.kiwilss.lxkj.xktx.core.click
import kotlinx.android.synthetic.main.activity_home.*

/**
 *@FileName: HomeActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
class HomeActivity : BaseActivity<HomePresenter>() {
    override fun initPresenter(): HomePresenter = HomePresenter()

    override fun handlerSuccess() {
        mPresenter.test1.observe(this, Observer {
            LogUtils.e(it)
            dismissLoadingDiloag()
            tv_home_info.text = it[0].title
        })
        mPresenter.loginData.observe(this, Observer {
            LogUtils.e(it.nickname)
        })
        mPresenter.collectData.observe(this, Observer {
            LogUtils.e(it)
        })
    }

    override fun initData() {
    }

    override fun initOnClick() {
        btn_home_test1.click {
            showLoadingDiloag()
            mPresenter.get()
        }
        btn_home_collect.click {
            mPresenter.getCollect()
        }
        btn_home_login.click {
            mPresenter.login()
        }
    }

    override fun initInterface(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int = R.layout.activity_home
}