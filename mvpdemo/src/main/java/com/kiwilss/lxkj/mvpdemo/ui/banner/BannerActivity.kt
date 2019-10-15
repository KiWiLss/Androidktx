/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BannerActivity
 * Author:   kiwilss
 * Date:     2019-09-17 14:55
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.mvpdemo.ui.banner

import android.os.Bundle
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.lxkj.basemvp.base.BaseActivity
import com.kiwilss.lxkj.mvpdemo.R
import com.kiwilss.lxkj.xktx.core.click
import kotlinx.android.synthetic.main.activity_banner.*

/**
 *@FileName: BannerActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
class BannerActivity : BaseActivity<BannerPresenter>() {
    override fun initPresenter(): BannerPresenter = BannerPresenter()

    override fun handlerSuccess() {
        mPresenter.dataResult.observe(this, Observer {
            dismissLoadingDiloag()
            it?.run {
                LogUtils.e(it)
                tv_banner_data.text = this.toString()
            }
        })
        mPresenter.collectData.observe(this, Observer {
            LogUtils.e(it)
        })
        mPresenter.loginData.observe(this, Observer {
            LogUtils.e(it)
        })
    }

    override fun initData() {
    }

    override fun initOnClick() {
        btn_banner_data.click {
            showLoadingDiloag()
            mPresenter.getData()
            //toastS("clcik")
        }
        btn_banner_collect.click {
            mPresenter.getCollect()
        }
        btn_banner_login.click {
            mPresenter.login()
        }
    }

    override fun initInterface(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int = R.layout.activity_banner
}