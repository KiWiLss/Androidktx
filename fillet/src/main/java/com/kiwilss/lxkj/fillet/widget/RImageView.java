package com.kiwilss.lxkj.fillet.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.kiwilss.lxkj.fillet.widget.helper.RImageViewHelper;


/**
 * RImageView
 *
 * @author ZhongDaFeng
 */
@SuppressLint("AppCompatCustomView")
public class RImageView extends ImageView {

    private RImageViewHelper mHelper;

    public RImageView(Context context) {
        this(context, null);
    }

    public RImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new RImageViewHelper(context, this, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (mHelper.isNormal()) {
            super.onDraw(canvas);
        } else {
            mHelper.onDraw(canvas);
        }
    }

    public RImageViewHelper getHelper() {
        return mHelper;
    }


}
