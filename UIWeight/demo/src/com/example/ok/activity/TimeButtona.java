package com.example.ok.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.csdn.Weight.Button.TimeButton;
import com.example.ok.R;

public class TimeButtona extends Activity implements View.OnClickListener {


    private TimeButton timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.time_button);
        timeButton = (TimeButton) findViewById(R.id.timeButton);
        timeButton.setTextBefore("点击获取验证码").setTextAfter("秒后重新获取").setLenght(10 * 1000);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeButton.start();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
