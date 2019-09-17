/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ImageViewExt
 * Author:   kiwilss
 * Date:     2019-09-17 14:50
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.mvpdemo.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

/**
 *@FileName: ImageViewExt
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019-09-17
 * @desc   : {DESCRIPTION}
 */

/**
 * Glide加载图片
 * @param url 可以是网络，可以是File，可以是资源id等等Glide支持的类型
 * @param placeholder 默认占位图
 * @param error 失败占位图
 * @param isCircle 是否是圆形，默认false，注意：isCircle和roundRadius两个只能有一个生效
 * @param isCenterCrop 是否设置scaleType为CenterCrop，你也可以在布局文件中设置
 * @param roundRadius 圆角角度，默认为0，不带圆角，注意：isCircle和roundRadius两个只能有一个生效
 * @param isCrossFade 是否有过渡动画，默认没有过渡动画
 * @param isForceOriginalSize 是否强制使用原图，默认false
 */
fun ImageView.load(url: Any?, placeholder: Int = 0, error: Int = 0,
                   isCircle: Boolean = false,
                   isCenterCrop: Boolean = false,
                   roundRadius: Int = 0,
                   isCrossFade: Boolean = false,
                   isForceOriginalSize: Boolean = false) {
    val options = RequestOptions().placeholder(placeholder).error(error).apply {
        if (isCenterCrop && scaleType != ImageView.ScaleType.CENTER_CROP)
            scaleType = ImageView.ScaleType.CENTER_CROP
        if (isCircle) {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                transforms(CenterCrop(), CircleCrop())
            } else {
                transform(CircleCrop())
            }
        } else if (roundRadius != 0) {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                transforms(CenterCrop(), RoundedCorners(roundRadius))
            } else {
                transform(RoundedCorners(roundRadius))
            }
        }
        if(isForceOriginalSize){
            override(Target.SIZE_ORIGINAL)
        }
    }
    Glide.with(context).load(url)
        .apply(options)
        .apply {
            if (isCrossFade) transition(DrawableTransitionOptions.withCrossFade())
        }
        .into(this)
}