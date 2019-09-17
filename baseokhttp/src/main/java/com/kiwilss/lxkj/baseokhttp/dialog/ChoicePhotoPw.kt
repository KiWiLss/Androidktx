/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ChoicePhotoPw2
 * Author:   kiwilss
 * Date:     2019-06-19 23:04
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.baseokhttp.dialog

import android.annotation.SuppressLint
import android.content.Context
import com.kiwilss.lxkj.baseokhttp.R
import com.lxj.xpopup.core.BottomPopupView
import kotlinx.android.synthetic.main.pw_normal_modify_header.view.*


/**
 *@FileName: ChoicePhotoPw2
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-06-19
 * @desc   : {DESCRIPTION}
 */
@SuppressLint("ViewConstructor")
class ChoicePhotoPw(context: Context, private val choiceOnClickListener: ChoiceOnClickListener)
    : BottomPopupView(context) {
    override fun getImplLayoutId(): Int {
        return R.layout.pw_normal_modify_header
    }

    override fun onCreate() {
        super.onCreate()


        tv_pw_modify_header_cancel.setOnClickListener {
            dismiss()
        }

        tv_pw_modify_header_take.setOnClickListener {
            dismiss()
            choiceOnClickListener.takePhoto()
        }

        tv_pw_modify_header_album.setOnClickListener {
            dismiss()
            choiceOnClickListener.openAlbum()
        }

    }


}

interface ChoiceOnClickListener{
    fun takePhoto()
    fun openAlbum()
}