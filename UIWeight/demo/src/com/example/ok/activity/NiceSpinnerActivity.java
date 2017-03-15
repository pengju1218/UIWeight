package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;

import com.csdn.Weight.TextView.NiceSpinner;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

import java.util.ArrayList;
import java.util.Arrays;

public class NiceSpinnerActivity extends BaseActivity implements View.OnClickListener {


    private com.csdn.Weight.TextView.NiceSpinner nicespinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nice_spinner);
        this.nicespinner = (NiceSpinner) findViewById(R.id.nicespinner);
        ArrayList<String> dataset = new ArrayList<>(Arrays.asList("12", "13", "15", "16"));
        nicespinner.attachDataSource(dataset);
    }


    @Override
    public void onClick(View v) {

    }


}
