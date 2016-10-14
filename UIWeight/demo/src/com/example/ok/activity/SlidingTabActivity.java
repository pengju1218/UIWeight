package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;

import com.csdn.Weight.HorizontalScrollView.SlidingTab;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class SlidingTabActivity extends BaseActivity implements View.OnClickListener {


    private SlidingTab slidingtab;
    private SlidingTab slidingtabslid;
    private String[] names1={"中国","中国","中国","中国"};
    private String[] names2={"中国","中国","中国","中国","中国","中国","中国","中国"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_tab);
        this.slidingtabslid = (SlidingTab) findViewById(R.id.slidingtab_slid);
        this.slidingtab = (SlidingTab) findViewById(R.id.slidingtab);
        slidingtab.setTitles(names1);
        slidingtabslid.setTitles(names2);
    }

    @Override
    public void onClick(View v) {

    }
}
