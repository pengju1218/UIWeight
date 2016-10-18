package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;

import com.csdn.Weight.LinearLayout.EmptyLine;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class EmptyActivity extends BaseActivity implements View.OnClickListener {


    private com.csdn.Weight.LinearLayout.EmptyLine empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_more);
        this.empty = (EmptyLine) findViewById(R.id.empty);
        empty.setOnSendDataListener(new EmptyLine.OnSendDataListener() {
            @Override
            public void send() {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
