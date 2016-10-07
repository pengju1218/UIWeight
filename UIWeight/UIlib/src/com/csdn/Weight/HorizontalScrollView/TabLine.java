package com.csdn.Weight.HorizontalScrollView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.csdn.Weight.R;
import com.csdn.Weight.util.Otin;


/**
 * Created by Administrator on 2016/9/19.
 */
public class TabLine extends HorizontalScrollView {

    LinearLayout linearLayout = null;
    private String[] name;
    private Context context;

    private float textSize;
    private int item_width;
    private int bg_color, select_color, unSelect_color, line_color;
    private boolean visiable = false;
    public void setName(String[] name) {
        this.name = name;
        initName();
    }


    public TabLine(Context context) {
        this(context, null);
        this.context = context;
    }

    public TabLine(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }// @formatter:off

    private static final int[] ATTRS = new int[]{
            android.R.attr.textSize,
            android.R.attr.textColor
    };

    public TabLine(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        setFillViewport(true);
        setWillNotDraw(false);
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        addView(linearLayout);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TabLineStyle);
        textSize = a.getDimensionPixelSize(R.styleable.TabLineStyle_tab_TextSize, 15);
        item_width = a.getDimensionPixelSize(R.styleable.TabLineStyle_tabItem_Width, 0);//单个的宽度
        bg_color = a.getColor(R.styleable.TabLineStyle_tab_BgColor, Color.LTGRAY);//
        visiable = a.getBoolean(R.styleable.TabLineStyle_tab_divide_Visiable, false);
        select_color = a.getColor(R.styleable.TabLineStyle_tab_SelectColor, Color.RED);//
        unSelect_color = a.getColor(R.styleable.TabLineStyle_tab_UnSelectColor, Color.WHITE);//
        line_color = a.getColor(R.styleable.TabLineStyle_tab_LineColor, Color.WHITE);//
    }


    private void initName() {
        if (name == null || name.length == 0) {
            return;
        }
        linearLayout.setBackgroundColor(bg_color);
        linearLayout.removeAllViews();

        for (int i = 0; i < name.length; i++) {

            final TextView textView = new TextView(context);
            linearLayout.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = null;
            if (0 == item_width) {
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            } else {
                params = new LinearLayout.LayoutParams(item_width, LinearLayout.LayoutParams.WRAP_CONTENT);
            }

            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText(name[i]);
            // textView.setTextColor(context.getResources().getColor(R.color.text_color_selector));
            textView.setTextSize(12);
            textView.setSingleLine();
            textView.setSelected(true);
            // linearLayout.addView(textView);
            // linearLayout.addView(tab, position, shouldExpand ? expandedTabLayoutParams : defaultTabLayoutParams)
            add(textView, i);
            View line = new View(context);
            LayoutParams params2 = new LayoutParams(Otin.getThis().dip2px(context, 1), LayoutParams.MATCH_PARENT);
            line.setLayoutParams(params2);
            int vi = visiable ? View.VISIBLE : View.GONE;
            line.setVisibility(vi);
            line.setBackgroundColor(line_color);
            if (i < name.length - 1) {
                linearLayout.addView(line);
            }
        }
    }


    public void add(final TextView textView, final int index) {
        linearLayout.addView(textView);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                initTextColors();
                textView.setTextColor(select_color);
                if (onSelectListener != null) {
                    onSelectListener.select(index);
                }
            }
        });
    }

    public void initTextColors() {

        int n = linearLayout.getChildCount();
        for (int i = 0; i < n; i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(unSelect_color);
            }
        }
    }

    private int number=0;
    public void setOnSelectTabIndex(int index) {
        int n = linearLayout.getChildCount();
        for (int i = 0; i < n; i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof TextView) {
                if (number == index) {
                    ((TextView) v).setTextColor(select_color);
                } else {
                    ((TextView) v).setTextColor(unSelect_color);
                }
                number++;
            }
        }
    }

    public OnSelectListener onSelectListener;

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.onSelectListener = onSelectListener;
    }

    public interface OnSelectListener {
        public void select(int index);
    }
}
