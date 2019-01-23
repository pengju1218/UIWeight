package com.example.ok.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.csdn.Weight.EditText.LineEditText;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class LineEditActivity extends BaseActivity {


    private LineEditText line_edit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line_edittext);
        initView();

    }


    private void initView() {
        line_edit = (LineEditText) findViewById(R.id.line_edit);
    }

    private void submit() {
        // validate
        String edit = line_edit.getText().toString().trim();
        if (TextUtils.isEmpty(edit)) {
            Toast.makeText(this, "edit不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}


