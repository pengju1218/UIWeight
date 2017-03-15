package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;

import com.csdn.Weight.View.CircleView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class ShowPercentActivity extends BaseActivity implements View.OnClickListener {



    private com.csdn.Weight.View.CircleView circleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_percent);
        this.circleview = (CircleView) findViewById(R.id.circle_view);

        circleview.setGradual(false);
        circleview.setCurrentDegree(1.0f);

    }

    @Override
    public void onClick(View v) {

    }
}
