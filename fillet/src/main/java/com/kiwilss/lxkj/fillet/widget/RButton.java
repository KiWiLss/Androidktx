package com.kiwilss.lxkj.fillet.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.kiwilss.lxkj.fillet.widget.helper.RTextViewHelper;
import com.kiwilss.lxkj.fillet.widget.iface.RHelper;


/**
 * RButton
 *
 * @author ZhongDaFeng
 */
@SuppressLint("AppCompatCustomView")
public class RButton extends Button implements RHelper<RTextViewHelper> {

    private RTextViewHelper mHelper;

    public RButton(Context context) {
        this(context, null);
    }

    public RButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new RTextViewHelper(context, this, attrs);
    }

    @Override
    public RTextViewHelper getHelper() {
        return mHelper;
    }

}
