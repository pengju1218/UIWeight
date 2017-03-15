package com.csdn.Weight.EditText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.csdn.Weight.R;


/**
 * 添加可以设置drawable大小的功能
 *
 * @author Daniel
 * @version 创建时间: Jul 26, 2012 5:28:59 PM
 */
public class EditViewPlus extends EditText implements View.OnFocusChangeListener, TextWatcher {
    // 需要从xml中读取的各个方向图片的宽和高
    private int leftHeight = -1;
    private int leftWidth = -1;
    private int rightHeight = -1;
    private int rightWidth = -1;
    private int topHeight = -1;
    private int topWidth = -1;
    private int bottomHeight = -1;
    private int bottomWidth = -1;
    private Drawable mClearDrawable;
    private boolean hasFoucs;

    public EditViewPlus(Context context) {
        super(context);
    }

    public EditViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        // super一定要在我们的代码之前配置文件
        init(context, attrs, 0);
    }

    public EditViewPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // super一定要在我们的代码之前配置文件
        init(context, attrs, defStyle);
    }

    /**
     * 初始化读取参数
     */
    private void init(Context context, AttributeSet attrs, int defStyle) {
        // TypeArray中含有我们需要使用的参数
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextViewPlus, defStyle, 0);
        bottomHeight = a.getDimensionPixelSize(R.styleable.TextViewPlus_bottom_height, -1);
        bottomWidth = a.getDimensionPixelSize(R.styleable.TextViewPlus_bottom_width, -1);
        leftHeight = a.getDimensionPixelSize(R.styleable.TextViewPlus_left_height, -1);
        leftWidth = a.getDimensionPixelSize(R.styleable.TextViewPlus_left_width, -1);
        rightHeight = a.getDimensionPixelSize(R.styleable.TextViewPlus_right_height, -1);
        rightWidth = a.getDimensionPixelSize(R.styleable.TextViewPlus_right_width, -1);
        topHeight = a.getDimensionPixelSize(R.styleable.TextViewPlus_top_height, -1);
        topWidth = a.getDimensionPixelSize(R.styleable.TextViewPlus_top_width, -1);
        // 获取各个方向的图片，按照：左-上-右-下 的顺序存于数组中
        Drawable[] drawables = getCompoundDrawables();
        int dir = 0;
        // 0-left; 1-top; 2-right; 3-bottom;
        for (Drawable drawable : drawables) {
            // 设定图片大小
            setImageSize(drawable, dir++);
        }
        // 将图片放回到TextView中
        setCompoundDrawables(drawables[0], drawables[1], drawables[2],
                drawables[3]);
        // 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片,获取图片的顺序是左上右下（0,1,2,3,）
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(
                    R.drawable.delete);
        }

        // 默认设置隐藏图标
        setClearIconVisible(true);
        // 设置焦点改变的监听
        setOnFocusChangeListener(this);
        // 设置输入框里面内容发生改变的监听
        addTextChangedListener(this);

    }

    protected void setClearIconVisible(boolean visible) {
        Drawable right = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    public void setDrawableLeft(Drawable drawable) {
        setImageSize(drawable, 0);
        setCompoundDrawables(drawable, null, null, null);
        invalidate();
    }

    public void setDrawableTop(Drawable drawable) {
        setImageSize(drawable, 1);
        setCompoundDrawables(null, drawable, null, null);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                Rect rect = getCompoundDrawables()[2].getBounds();
                int height = rect.height();
                int distance = (getHeight() - height) / 2;
                boolean isInnerWidth = x > (getWidth() - getTotalPaddingRight()) && x < (getWidth() - getPaddingRight());
                boolean isInnerHeight = y > distance && y < (distance + height);
                if (isInnerWidth && isInnerHeight) {
                    this.setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public void setDrawableBottom(Drawable drawable) {
        setImageSize(drawable, 3);
        setCompoundDrawables(null, null, null, drawable);
        invalidate();
    }

    public void setDrawabRight(Drawable drawable) {
        setImageSize(drawable, 2);
        setCompoundDrawables(null, null, drawable, null);
        invalidate();
    }

    /**
     * 设定图片的大小
     */
    private void setImageSize(Drawable d, int dir) {
        if (d == null) {
            return;
        }

        int height = -1;
        int width = -1;
        // 根据方向给宽和高赋值
        switch (dir) {
            case 0:
                // left
                height = leftHeight;
                width = leftWidth;
                break;
            case 1:
                // top
                height = topHeight;
                width = topWidth;
                break;
            case 2:
                // right
                height = rightHeight;
                width = rightWidth;
                break;
            case 3:
                // bottom
                height = bottomHeight;
                width = bottomWidth;
                break;
        }
        // 如果有某个方向的宽或者高没有设定值，则不去设定图片大小
        if (width != -1 && height != -1) {
            d.setBounds(0, 0, width, height);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (hasFoucs) {
            setClearIconVisible(s.length() > 0);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFoucs = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }
}