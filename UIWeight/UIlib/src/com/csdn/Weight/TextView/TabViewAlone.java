package com.csdn.Weight.TextView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.csdn.Weight.R;

public class TabViewAlone extends TextView {

       /* <declare-styleable name="TabViewAlone">
        <attr name="tabViewUpDraw" format="reference"></attr>
        <attr name="iconPadding" format="dimension"/>
        <attr name="iconWidth" format="dimension"/>
        <attr name="iconHeight" format="dimension"/>
                <attr name="tabViewAlone_UpDraw" format="reference"/>
        <attr name="tabViewAlone_iconPadding" format="dimension"/>
        <attr name="tabViewAlone_iconWidth" format="dimension"/>
        <attr name="tabViewAlone_iconHeight" format="dimension"/>
        <attr name="tabViewAlone_tab_textSize" format="dimension"/>
    </declare-styleable>*/

    private float iconHeight,iconWidth,iconPadding,tab_textSize;

    private int upDraw;

    public final TypedArray obtainStyledAttributes(AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        throw new RuntimeException("Stub!");
    }
    public void init(Context context,AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.tabViewAlone,0, 0);
        if (a != null) {
            upDraw=a.getResourceId(R.styleable.tabViewAlone_tabViewAlone_UpDraw,R.drawable.ic_launcher);
            iconHeight=a.getDimension(R.styleable.tabViewAlone_tabViewAlone_iconHeight,20);
            iconWidth=a.getDimension(R.styleable.tabViewAlone_tabViewAlone_iconWidth,20);
            iconPadding=a.getDimension(R.styleable.tabViewAlone_tabViewAlone_iconPadding,20);

            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);


            this.setGravity(Gravity.CENTER_HORIZONTAL);
            this.setSingleLine(true);
            this.setVisibility(VISIBLE);

            this.setEllipsize(TextUtils.TruncateAt.END);
            this.setLayoutParams(layoutParams);
        }

    }



   /* public TabViewAlone(Context context) {
        this(context, null, R.style.TabViewAloneStyle_Alone);

    }*/

    public TabViewAlone(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);

    }

    public TabViewAlone(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidth(),heightMeasureSpec+(int)getTextSize());

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (upDraw>0) {

            Drawable drawable=getContext().getResources().getDrawable(upDraw);
            float width = iconWidth == 0 ? drawable.getIntrinsicWidth() : iconWidth;
            float height = iconHeight == 0 ? drawable.getIntrinsicHeight() : iconHeight;
            drawable.setBounds(0, 0, (int)width, (int)height);
            setCompoundDrawables(null, drawable, null, null);
        }
        this.setCompoundDrawablePadding((int)iconPadding);
        invalidate();

    }


}
