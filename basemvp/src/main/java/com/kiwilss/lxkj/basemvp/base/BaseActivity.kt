/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BaseActivity
 * Author:   kiwilss
 * Date:     2019-09-16 15:34
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.basemvp.base

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.AdaptScreenUtils
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.lxkj.basemvp.dialog.loading.LoadingPopupTwo
import com.kiwilss.lxkj.basemvp.manage.ActivityCollector
import com.kiwilss.lxkj.basemvp.util.toastE
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import kotlinx.android.synthetic.main.currency_top.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.ref.WeakReference

/**
 *@FileName: BaseActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-16
 * @desc   : {DESCRIPTION}
 */
abstract class BaseActivity<T: BasePresenter> : AppCompatActivity(){

    val mPresenter: T by lazy {
        initPresenter()
    }

    abstract fun initPresenter(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局前操作
        doBeforeSetContentView(savedInstanceState)
        //设置布局
        setContentView(getLayoutId())
        //设置状态栏
        setStatusBar()
        //当前活动加入活动管理器
        ActivityCollector.instance().addActivity(this)

        //关联presenter
        mPresenter.attech(this)

        //初始化主界面
        initInterface(savedInstanceState)
        //初始化点击事件
        initOnClick()
        //处理各种网络请求失败的结果
        handlerError()
        //处理成功返回结果
        handlerSuccess()
        //初始化数据
        initData()
        //初始化标题
        initToolbarTitle()
        //设置返回监听
        setBackListener()
    }

    //对屏幕适配
    override fun getResources(): Resources {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 375)
    }

    open fun setBackListener() {
        //设置返回点击
        iv_currency_top_back?.let { it ->
            it.setOnClickListener { onBackPressed() }
        }
    }

    open fun initToolbarTitle() {
        //设置标题
        tv_currency_top_title?.let {
            it.text = title
        }
    }

    abstract fun handlerSuccess()

    open fun handlerError() {
        mPresenter.error.observe(this, Observer {
            dismissLoadingDiloag()
            LogUtils.e(it)
            toastE(it)
        })
    }

    abstract fun initData()

    abstract fun initOnClick()

    abstract fun initInterface(savedInstanceState: Bundle?)

    open fun setStatusBar() {
//        ImmersionBar
//            .with(this)
//            .init()
    }

    abstract fun getLayoutId(): Int

    open fun doBeforeSetContentView(savedInstanceState: Bundle?) {
    }

    @ExperimentalCoroutinesApi
    override fun onDestroy() {
        ActivityCollector.instance().removeActivity2(this)
        mPresenter.detach()
        dismissLoadingDiloag()
        super.onDestroy()
    }

    //对话框
    var mLoadingMessage = "加载中..."

    var mBasePopup: BasePopupView? = null

    val weakReference by lazy { WeakReference(this) }

    fun showLoadingDiloag(){
        showLoadingDiloag(mLoadingMessage)
    }

    fun showLoadingDiloag(message: String){
        mBasePopup?.apply {
            dismiss()
        }
        //XPopup.setAnimationDuration(200)
        //val contextweakReference.get()
        mBasePopup = XPopup.Builder(this)
            //.popupAnimation(PopupAnimation.NoAnimation)
            .hasShadowBg(false)
            .dismissOnBackPressed(false)
            .dismissOnTouchOutside(false)
            .asCustom( LoadingPopupTwo(this).setTitle(message) )
            .show()

    }

    fun dismissLoadingDiloag(){
        mBasePopup?.apply {
            dismiss()
        }
        //mBasePopup = null
    }

}