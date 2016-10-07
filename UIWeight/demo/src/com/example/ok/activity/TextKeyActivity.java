package com.example.ok.activity;

import android.os.Bundle;

import com.csdn.Weight.TextView.KeyTextView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class TextKeyActivity extends BaseActivity {

    private com.csdn.Weight.TextView.KeyTextView keyte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_key);
        this.keyte = (KeyTextView) findViewById(R.id.key_te);
        keyte.setValue("99.99");
    }


}
