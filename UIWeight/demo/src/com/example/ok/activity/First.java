package com.example.ok.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ok.R;

/**
 * Created by Administrator on 2016/9/7.
 */
public class First extends Activity {

    private android.widget.ListView listview;
    private Class<?>[] aClass = {Test.class, PassLenth.class, TimeButtona.class, RoundImageA.class,
            TextViewPlusA.class, MainActivity.class, MoreTextA.class,
            TabActivity.class, CircleImgActivity.class,
            TextKeyActivity.class, DashLineActivity.class, SlidingTabActivity.class, EmptyActivity.class,
            ToastActivity.class, TimeActivity.class,NumberImgActivity.class,
            CropImgActivity.class,HortalListView.class,TypeScrollActivity.class

    };
    private String[] strings = {"SizeRadio(可自定义图片大小单选按钮)",
            "PasswordInputView(密码长度定长)", "TimeButton(验证60s)",
            "RoundImage(下载网张图片)", "TextViewPlus(图标大小)",
            "对话框", "折叠文本", "tab标签", "圆形图片",
            "组合字体", "虚线", "滑动tab", "网络状态", "Toast自定义", "倒计时",
            "图片角标","图片裁减","水平ListView","滑动分类"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        this.listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                First.this, R.layout.line_item,
                strings);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(First.this, aClass[position]);
                startActivity(intent);
            }
        });
    }
}
