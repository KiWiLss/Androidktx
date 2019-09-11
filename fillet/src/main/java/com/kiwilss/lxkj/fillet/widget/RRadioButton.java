package com.kiwilss.lxkj.fillet.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RadioButton;

import com.kiwilss.lxkj.fillet.widget.helper.RCheckHelper;
import com.kiwilss.lxkj.fillet.widget.iface.RHelper;


/**
 * RRadioButton
 *
 * @author ZhongDaFeng
 */
@SuppressLint("AppCompatCustomView")
public class RRadioButton extends RadioButton implements RHelper<RCheckHelper> {

    private RCheckHelper mHelper;

    public RRadioButton(Context context) {
        this(context, null);
    }

    public RRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new RCheckHelper(context, this, attrs);
    }

    @Override
    public RCheckHelper getHelper() {
        return mHelper;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (mHelper != null) {
            mHelper.setEnabled(enabled);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mHelper != null) {
            mHelper.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

}
