package com.example.ok.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.csdn.Weight.LinearLayout.EmptyLine;
import com.csdn.Weight.Toast.CToast;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class ToastActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_layout);
        CToast.makeText(ToastActivity.this, "我来自CToast!", 5000).show();


    }

    @Override
    public void onClick(View v) {

    }
}
