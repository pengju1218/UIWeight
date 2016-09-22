package com.example.ok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by Administrator on 2016/9/7.
 */
public class First extends Activity {

    private android.widget.ListView listview;
    private Class<?>[] aClass = {Test.class, PassLenth.class, TimeButtona.class, RoundImageA.class,
            TextViewPlusA.class, MainActivity.class, MoreTextA.class,
            TabActivity.class,CircleImgActivity.class,TextKeyActivity.class};
    private String[] strings = {"SizeRadio(可自定义图片大小单选按钮)",
            "PasswordInputView(密码长度定长)", "TimeButton(验证60s)",
            "RoundImage(下载网张图片)", "TextViewPlus(图标大小)",
            "对话框", "折叠文本", "tab标签","圆形图片","组合字体"};

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
