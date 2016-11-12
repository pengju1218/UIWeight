package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.csdn.Weight.ImageView.NumImageView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class NumberImgActivity extends BaseActivity implements View.OnClickListener {


    private NumImageView nubmerimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_img);
        this.nubmerimg = (NumImageView) findViewById(R.id.nubmer_img);

        nubmerimg.setNum(10);
    }




    @Override
    public void onClick(View v) {

    }


}
