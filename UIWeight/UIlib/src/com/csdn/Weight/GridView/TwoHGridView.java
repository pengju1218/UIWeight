package com.csdn.Weight.GridView;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class TwoHGridView extends GridView {
    public TwoHGridView(Context context) {
        super(context);
    }

    public TwoHGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TwoHGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO 自动生成的方法存根
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
