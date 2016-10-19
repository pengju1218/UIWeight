package com.example.ok.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
                sendData();
            }
        });
    }
    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                empty.setProGone();
                if(true){
                    empty.setVisibility(View.VISIBLE);
                }
            }
        }
    };
    public void  sendData(){



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },10);


    }

    @Override
    public void onClick(View v) {

    }
}
