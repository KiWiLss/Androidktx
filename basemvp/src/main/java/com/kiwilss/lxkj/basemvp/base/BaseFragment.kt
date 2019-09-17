/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BaseFragment
 * Author:   kiwilss
 * Date:     2019-09-16 18:06
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.basemvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kiwilss.lxkj.basemvp.dialog.loading.LoadingPopupTwo
import com.kiwilss.lxkj.basemvp.util.toastE
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.enums.PopupAnimation
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 *@FileName: BaseFragment
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-16
 * @desc   : {DESCRIPTION}
 */
abstract class BaseFragment <T: BasePresenter>: Fragment(){

    val mPresenter: T by lazy {
        initPresenter()
    }

    abstract fun initPresenter(): T

    var mRootView: View? = null
    var isViewPrepare = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null){
            mRootView = inflater.inflate(getLayoutId(),container,false)
        }
        mPresenter.attech(context)
        return mRootView
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initInterface(view,savedInstanceState)
        //处理各种网络请求失败的结果
        handlerError()
        //处理成功结果
        handlerSuccess()
        initData()
        initOnClick()
    }

    abstract fun initOnClick()

    abstract fun initData()

    private fun handlerError() {
        mPresenter.error.observe(this, Observer {
            dismissLoadingDiloag()
            toastE(it)
        })
    }

    abstract fun handlerSuccess()

    abstract fun initInterface(view: View, savedInstanceState: Bundle?)


    var mLoadingMessage = "加载中..."

    var mBasePopup: BasePopupView? = null

    fun showLoadingDiloag(){
        showLoadingDiloag(mLoadingMessage)
    }

    fun showLoadingDiloag(message: String){
        mBasePopup?.apply {
            if (isShow) {
                dismiss()
            }
        }
        mBasePopup = XPopup.Builder(context)
            .hasShadowBg(false)
            .popupAnimation(PopupAnimation.NoAnimation)
            .dismissOnBackPressed(false)
            .dismissOnTouchOutside(false)
            .asCustom(LoadingPopupTwo(context!!).setTitle(message))
            .show()
    }

    fun dismissLoadingDiloag(){
        mBasePopup?.apply {
            dismiss()
        }
    }


    @ExperimentalCoroutinesApi
    override fun onDestroyView() {
        dismissLoadingDiloag()
        mPresenter.detach()
        super.onDestroyView()
    }
}