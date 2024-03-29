package com.kiwilss.lxkj.fillet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.kiwilss.lxkj.fillet.widget.helper.RBaseHelper;
import com.kiwilss.lxkj.fillet.widget.iface.RHelper;


/**
 * RLinearLayout
 *
 * @author ZhongDaFeng
 */
public class RLinearLayout extends LinearLayout implements RHelper<RBaseHelper> {

    private RBaseHelper mHelper;

    public RLinearLayout(Context context) {
        this(context, null);
    }

    public RLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new RBaseHelper(context, this, attrs);
    }

    @Override
    public RBaseHelper getHelper() {
        return mHelper;
    }
}
