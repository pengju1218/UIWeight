package com.csdn.Weight.HorizontalScrollView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csdn.Weight.ListView.HorizontalListView;
import com.csdn.Weight.R;
import com.csdn.Weight.adapter.Base.OnItemClickListener;
import com.csdn.Weight.util.Otin;

/**
 * Created by Administrator on 2016/12/23.
 */

public class TypeScroller extends HorizontalScrollView implements View.OnClickListener {


    private int selectId = 1;
    private Context context;
    private LinearLayout container;
    private int other_margin_vspce = 5, other_margin_hspce = 10;
    private int first_margin_left = 5;

    public TypeScroller(Context context) {
        this(context, null);
        this.context = context;
    }

    public TypeScroller(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }// @formatter:off


    public TypeScroller(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init(attrs);
    }


    public void init(AttributeSet attrs) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Otin.getThis().dip2px(context, 50));
        params.gravity = Gravity.CENTER_VERTICAL;
        this.setLayoutParams(params);
        this.setBackgroundColor(Color.WHITE);
        this.setHorizontalScrollBarEnabled(false);


        /**
         * 这是容器
         */
        container = new LinearLayout(getContext());
        LinearLayout.LayoutParams container_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        container_params.gravity = Gravity.CENTER_VERTICAL;
        container_params.setMargins(0, Otin.getThis().dip2px(context, 5), 0, 0);
        container.setOrientation(LinearLayout.HORIZONTAL);
        this.addView(container);


        //获取attr
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TypeScroller);
        other_margin_hspce = a.getDimensionPixelSize(R.styleable.TypeScroller_typescroller_Hspace, Otin.getThis().dip2px(context, 5));//水平间距
        other_margin_vspce = a.getDimensionPixelSize(R.styleable.TypeScroller_typescroller_Vspace, Otin.getThis().dip2px(context, 2));//垂直间距
        first_margin_left = a.getDimensionPixelSize(R.styleable.TypeScroller_typescroller_first_left, Otin.getThis().dip2px(context, 5));//第一个水平的间距
    }


    public void setTitles(String[] titles1) {
        //① 创建item布局，并添加到水平线性布局中
        //由于第一个和其他的item不一样所以我们分别添加，相应的为其添加两种不同的item布局
        //第一种item布局不要加边框背景
        //第二种item布局要加边框背景
        TextView first_txt = new TextView(getContext());
        LinearLayout.LayoutParams first_txt_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //first_txt_params.setMargins(Otin.getThis().dip2px(context, 5), Otin.getThis().dip2px(context, 2), Otin.getThis().dip2px(context, 5), 0);
        first_txt_params.setMargins(first_margin_left, 0, 0, 0);
        first_txt_params.gravity = Gravity.CENTER_VERTICAL;
        first_txt.setLayoutParams(first_txt_params);
        first_txt.setTextColor(Color.parseColor("#99000000"));
        first_txt.setTextSize(16);
        first_txt.setText(titles1[0]);
        //添加进去
        container.addView(first_txt);

        // ③ 再循环添加后面的数据
        for (int i = 1; i < titles1.length; i++) {
            TextView text_other = new TextView(getContext());
            LinearLayout.LayoutParams text_other_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            text_other_params.setMargins(other_margin_hspce, other_margin_vspce, other_margin_hspce, other_margin_vspce);
            text_other_params.gravity = Gravity.CENTER_VERTICAL;
            text_other.setLayoutParams(text_other_params);
            text_other.setTextColor(Color.parseColor("#000000"));
            text_other.setTextSize(15);
            text_other.setText(titles1[i]);

            onItemClick(text_other, i);
            //添加进去
            container.addView(text_other);
            notifyChange();
        }
    }


    public void notifyChange() {

        int count = container.getChildCount();
        for (int i = 1; i < count; i++) {
            TextView textView1 = (TextView) container.getChildAt(i);
            if (i == selectId) {
                textView1.setBackgroundResource(R.drawable.hscroll_shape_checked);
            } else {
                textView1.setBackgroundResource(R.drawable.hscroll_shape_unchecked);
            }

        }
    }


    public void onItemClick(TextView textView, final int index) {




        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectId = index;
                if (onItemClickListener != null) {
                    onItemClickListener.item(index);
                    notifyChange();
                }
            }
        });

    }


    @Override
    public void onClick(View v) {

    }


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void item(int i);
    }
}
