package com.yj.letgo.diyviews.viewdraghelper;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class VDHLinearLayout extends LinearLayout {

    private ViewDragHelper mViewDragHelper = null;

    public VDHLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        createVDH(null);
    }

    public void createVDH(ViewDragHelper.Callback callback) {
        if (callback == null) {
            mViewDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
                @Override
                public boolean tryCaptureView(View child, int pointerId) {
                    return true;
                }
            });
        } else {
            mViewDragHelper = ViewDragHelper.create(this, 1.0f, callback);
        }
    }

      @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mViewDragHelper == null) {
            return super.dispatchTouchEvent(event);
        }
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mViewDragHelper == null) {
            return super.onInterceptTouchEvent(ev);
        }
        int keyCode = ev.getAction();
        if (keyCode == MotionEvent.ACTION_CANCEL) {
            mViewDragHelper.cancel();
            return false;
        }
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }
    
    public ViewDragHelper getViewDragHelper() {
        return mViewDragHelper;
    }
}
