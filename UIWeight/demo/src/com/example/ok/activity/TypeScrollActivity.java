package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;

import com.csdn.Weight.HorizontalScrollView.TypeScroller;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class TypeScrollActivity extends BaseActivity implements View.OnClickListener {

    private String[] titles1 = {"类型", "爱情", "喜剧", "动画", "剧情", "恐怖", "惊悚", "科幻", "动作", "悬疑", "冒险", "战争", "奇幻", "运动", "家庭", "古装", "武侠", "西部", "历史", "传记", "情色", "歌舞", "短片", "纪录片", "其他"};
    private String[] titles2 = {"地区", "大陆", "美国", "韩国", "日本", "中国", "中国香港", "中国台湾", "泰国", "印度", "法国", "英国", "澳大利亚", "其他"};
    private String[] titles3 = {"年代", "2017以后", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "90年代", "80年代", "70年代", "其他"};
    private com.csdn.Weight.HorizontalScrollView.TypeScroller testscoller;
    private TypeScroller testscoller1;
    private TypeScroller testscoller2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_scroll);
        this.testscoller2 = (TypeScroller) findViewById(R.id.test_scoller2);
        this.testscoller1 = (TypeScroller) findViewById(R.id.test_scoller1);
        this.testscoller = (TypeScroller) findViewById(R.id.test_scoller);

        testscoller.setTitles(titles1);
        testscoller.setOnItemClickListener(new TypeScroller.OnItemClickListener() {
            @Override
            public void item(int i) {
                showTast(i+"");
            }
        });


        testscoller1.setTitles(titles2);
        testscoller1.setOnItemClickListener(new TypeScroller.OnItemClickListener() {
            @Override
            public void item(int i) {
                showTast(i+"");
            }
        });


        testscoller2.setTitles(titles3);
        testscoller2.setOnItemClickListener(new TypeScroller.OnItemClickListener() {
            @Override
            public void item(int i) {
                showTast(i+"");
            }
        });



    }

    @Override
    public void onClick(View v) {

    }
}
