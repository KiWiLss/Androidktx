package com.kiwilss.lxkj.fillet.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.kiwilss.lxkj.fillet.widget.helper.RTextViewHelper;
import com.kiwilss.lxkj.fillet.widget.iface.RHelper;


/**
 * RTextView
 *
 * @author ZhongDaFeng
 */
@SuppressLint("AppCompatCustomView")
public class RTextView extends TextView implements RHelper<RTextViewHelper> {

    private RTextViewHelper mHelper;

    public RTextView(Context context) {
        this(context, null);
    }

    public RTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new RTextViewHelper(context, this, attrs);
    }

    @Override
    public RTextViewHelper getHelper() {
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
