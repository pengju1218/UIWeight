package com.example.ok.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.csdn.Weight.GridView.LineGridView;
import com.csdn.Weight.GridView.TwoHGridView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class TwoHGridActivity extends BaseActivity {
    private LineGridView line_grid;
    DisplayMetrics dm;
    private int NUM = 2; // 每行显示个数
    private int hSpacing = 20;// 水平间距
    private String[] strings = {"SizeRadio(可自定义图片大小单选按钮)",
            "PasswordInputView(密码长度定长)", "TimeButton(验证60s)",
            "RoundImage(下载网张图片)", "TextViewPlus(图标大小)",
            "对话框", "折叠文本", "tab标签", "圆形图片",
            "组合字体", "虚线", "滑动tab", "网络状态", "Toast自定义", "倒计时",
            "图片角标", "图片裁减", "水平ListView", "滑动分类", "引导页", "下拉(NiceSpinner)", "进度", "Grid分割线"};
    private TwoHGridView gridView1;
    private LinearLayout linearLayout1;
    private HorizontalScrollView scrollView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_grid);
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        initView();
    }

    private void initView() {
        line_grid = (LineGridView) findViewById(R.id.line_grid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                TwoHGridActivity.this, R.layout.line_item2,
                strings);

        gridView1 = (TwoHGridView) findViewById(R.id.gridView1);

        gridView1.setAdapter(arrayAdapter);

      //  arrayAdapter.updata(context, typeBean.data);//这是我定义的adapter加载数据，
        int count = arrayAdapter.getCount();
        int columns = (count % 2 == 0) ? count / 2 : count / 2 + 1;
        gridView1.setAdapter(arrayAdapter);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(columns * dm.widthPixels / NUM,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        gridView1.setLayoutParams(params);
        gridView1.setColumnWidth(dm.widthPixels / NUM);
        gridView1.setStretchMode(GridView.NO_STRETCH);
        if (count <= 3) {
            gridView1.setNumColumns(count);
        } else {
            gridView1.setNumColumns(columns);
        }
    }
}


