package com.example.ok.activity;

import android.os.Bundle;

import com.csdn.Weight.HorizontalScrollView.TypeScollerLine;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class TypeSActivity extends BaseActivity {

    private String[] titles1 = {"类型", "爱情", "喜剧", "动画", "剧情", "恐怖", "惊悚", "科幻", "动作", "悬疑", "冒险", "战争", "奇幻", "运动", "家庭", "古装", "武侠", "西部", "历史", "传记", "情色", "歌舞", "短片", "纪录片", "其他"};

    private TypeScollerLine types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.types);
        initView();


    }

    private void initView() {
        types = (TypeScollerLine) findViewById(R.id.types);
        types.setTypes(titles1);
    }
}