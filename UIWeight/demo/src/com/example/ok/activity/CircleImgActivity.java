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

public class CircleImgActivity extends BaseActivity implements View.OnClickListener {
    private android.widget.ImageView circleimg;

    String imageUrl = "http://d.hiphotos.baidu.com/image/pic/item/9358d109b3de9c8242a7de176e81800a18d84363.jpg";
    private com.csdn.Weight.ImageView.RoundImageView userAvater;

    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_img);
        this.userAvater = (RoundImageView) findViewById(R.id.userAvater);
        imageLoader = OrderUtil.getInstance().initImageLoader(CircleImgActivity.this, imageLoader, "test");
        initImageLoader();
        //ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(CircleImgActivity.this));
        this.circleimg = (ImageView) findViewById(R.id.circle_img);

        ImageLoader.getInstance().displayImage(imageUrl, circleimg, options);
        imageLoader.displayImage(imageUrl,userAvater);

    }


    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(new CircleBitmapDisplayer())
            .build();

    @Override
    public void onClick(View v) {

    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheExtraOptions(1024, 1024, null)
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileCount(100)
                .build();
        ImageLoader.getInstance().init(config);
    }
}
