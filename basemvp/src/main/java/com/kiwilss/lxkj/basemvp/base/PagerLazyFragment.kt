/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: PagerLazyFragment
 * Author:   kiwilss
 * Date:     2019-09-17 10:23
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
 *@FileName: PagerLazyFragment
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */
abstract class PagerLazyFragment<T: BasePresenter> : Fragment(){
    var isInit = false

    var mRootView: View? = null

    val mPresenter: T by lazy {
        initPresenter()
    }

    abstract fun initPresenter(): T

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
        lazyInit()
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        lazyInit()
    }

    private fun lazyInit() {
        if (mRootView != null && userVisibleHint && !isInit ) {
            isInit = true
            //处理各种网络请求失败的结果
            handlerError()
            //处理成功结果
            handlerSuccess()
            initInterface()
            initData()
        }
    }

    abstract fun handlerSuccess()

    abstract fun initData()

    abstract fun initInterface()

    private fun handlerError() {
        mPresenter.run {
            error.observe(this@PagerLazyFragment, Observer {
                dismissLoadingDiloag()
                toastE(it)
            })
        }
    }

    @ExperimentalCoroutinesApi
    override fun onDestroyView() {
        dismissLoadingDiloag()
        mPresenter.detach()
        super.onDestroyView()
    }

    var mLoadingMessage = "加载中..."

    private var mBasePopup: BasePopupView? = null

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


}