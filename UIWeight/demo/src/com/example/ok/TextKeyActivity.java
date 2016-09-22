package com.example.ok;

import android.os.Bundle;

import com.csdn.Weight.TextView.KeyTextView;
import com.example.ok.Base.BaseActivity;

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
