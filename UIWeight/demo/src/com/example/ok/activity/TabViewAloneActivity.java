package com.example.ok.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.csdn.Weight.ImageView.RoundImageView;
import com.csdn.Weight.ImageView.displayers.CircleBitmapDisplayer;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;
import com.example.ok.util.OrderUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class TabViewAloneActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabviewalone);
    }
}