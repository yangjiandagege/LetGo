package com.yj.letgo.diyviews.viewdraghelper;

import com.yj.letgo.R;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private VDHLinearLayout mVDHLiearLayout;
    private TextView mDragView;
    private TextView mAutobackView;
    private TextView mEdgeView;

    Point mAutobackPoint = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiwdraghelper);

        mDragView = (TextView) findViewById(R.id.child1);
        mAutobackView = (TextView) findViewById(R.id.child2);
        mEdgeView = (TextView) findViewById(R.id.child3);
        mVDHLiearLayout = (VDHLinearLayout) findViewById(R.id.root_vdh);
        init();
    }

    protected void init() {
        mVDHLiearLayout.createVDH(new VDHCallback());
        mAutobackView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAutobackPoint.set(mAutobackView.getLeft(), mAutobackView.getTop());
            }
        }, 0);
    }

    class VDHCallback extends ViewDragHelper.Callback {

        /**
         * 此例中 mEdgeView将无法被拖动
         * 此函数必须实现
         *
         * @param child
         * @param pointerId
         * @return if false,那么child view将无法拖动（Drag）
         */
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            if (child == mEdgeView) {//
                return false;
            }
            return true;
        }

        /**
         * 实现对child view x 轴方向的控制
         *
         * @param child
         * @param left
         * @param dx
         * @return
         */
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            int leftBound = mVDHLiearLayout.getPaddingLeft();
            int rightBound = mVDHLiearLayout.getWidth() - mVDHLiearLayout.getPaddingRight() - child.getWidth();
//                if(left<leftBound){
//                    left = leftBound;
//                }else if(left>rightBound){
//                    left = rightBound;
//                }
            //更加简洁的写法
            left = Math.min(Math.max(left, leftBound), rightBound);
            return left;
        }

        /**
         * 对child view y 轴方向的控制
         *
         * @param child
         * @param top
         * @param dy
         * @return
         */
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            int topBound = mVDHLiearLayout.getPaddingTop();
            int bottomBound = mVDHLiearLayout.getHeight() - child.getHeight() - mVDHLiearLayout.getPaddingBottom();
            if (top < topBound) {
                top = topBound;
            } else if (top > bottomBound) {
                top = bottomBound;
            }
            return top;
        }
    }

}
