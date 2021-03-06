package com.csdn.Weight.Button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

import com.csdn.Weight.R;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SizeRadio  extends RadioButton {

    private int mDrawableSize;// xml文件中设置的大小
    private int mDrawablePadding;

    public SizeRadio(Context context) {
        this(context, null, 0);
    }

    public SizeRadio(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SizeRadio(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        Drawable drawableLeft = null, drawableTop = null, drawableRight = null, drawableBottom = null;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SizeRadioStyle);


        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            Log.i("MyRadioButton", "attr:" + attr);
            if(R.styleable.SizeRadioStyle_sizeRadio_drawableSize==attr){
                mDrawableSize = a.getDimensionPixelSize(R.styleable.SizeRadioStyle_sizeRadio_drawableSize, 50);
            }else if(R.styleable.SizeRadioStyle_sizeRadio_drawableTop==attr){
                drawableTop = a.getDrawable(attr);
            }else if(R.styleable.SizeRadioStyle_sizeRadio_drawableLeft==attr){
                drawableLeft= a.getDrawable(attr);
            }else if(R.styleable.SizeRadioStyle_sizeRadio_drawableBottom==attr){
                drawableBottom = a.getDrawable(attr);
            }else if(R.styleable.SizeRadioStyle_sizeRadio_drawableRight==attr){
                drawableRight = a.getDrawable(attr);
            }else if(R.styleable.SizeRadioStyle_sizeRadio_drawablePadding==attr){
                mDrawablePadding =a.getDimensionPixelSize(R.styleable.SizeRadioStyle_sizeRadio_drawablePadding, 10);
            }
        }
        a.recycle();

        setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);

    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left,
                                                        Drawable top, Drawable right, Drawable bottom) {

        if (left != null) {
            left.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        this.setCompoundDrawablePadding(mDrawablePadding);
        setCompoundDrawables(left, top, right, bottom);
    }

}
