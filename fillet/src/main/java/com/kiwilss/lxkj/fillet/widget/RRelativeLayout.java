package com.kiwilss.lxkj.fillet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.kiwilss.lxkj.fillet.widget.helper.RBaseHelper;
import com.kiwilss.lxkj.fillet.widget.iface.RHelper;


/**
 * RRelativeLayout
 *
 * @author ZhongDaFeng
 */
public class RRelativeLayout extends RelativeLayout implements RHelper<RBaseHelper> {

    private RBaseHelper mHelper;

    public RRelativeLayout(Context context) {
        this(context, null);
    }

    public RRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new RBaseHelper(context, this, attrs);
    }

    @Override
    public RBaseHelper getHelper() {
        return mHelper;
    }
}
