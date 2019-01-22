package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csdn.Weight.GridView.LineGridView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class LineGridActivity extends BaseActivity {
    private LineGridView line_grid;
    private String[] strings = {"SizeRadio(可自定义图片大小单选按钮)",
            "PasswordInputView(密码长度定长)", "TimeButton(验证60s)",
            "RoundImage(下载网张图片)", "TextViewPlus(图标大小)",
            "对话框", "折叠文本", "tab标签", "圆形图片",
            "组合字体", "虚线", "滑动tab", "网络状态", "Toast自定义", "倒计时",
            "图片角标","图片裁减","水平ListView","滑动分类","引导页","下拉(NiceSpinner)","进度","Grid分割线"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_grid);
        initView();
    }

    private void initView() {
        line_grid = (LineGridView) findViewById(R.id.line_grid);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                LineGridActivity.this, R.layout.line_item,
                strings);
        line_grid.setAdapter(arrayAdapter);
    }


}


