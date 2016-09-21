package com.example.ok;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.csdn.Weight.ImageView.displayers.CircleBitmapDisplayer;
import com.example.ok.Base.BaseActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class CircleImgActivity extends BaseActivity implements View.OnClickListener {
    private android.widget.ImageView circleimg;

    String imageUrl = "http://d.hiphotos.baidu.com/image/pic/item/9358d109b3de9c8242a7de176e81800a18d84363.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_img);
        initImageLoader();
        //ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(CircleImgActivity.this));
        this.circleimg = (ImageView) findViewById(R.id.circle_img);

        ImageLoader.getInstance().displayImage(imageUrl,circleimg,options);

    }


    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(new CircleBitmapDisplayer())
            .build();
    @Override
    public void onClick(View v) {

    }

    private void initImageLoader(){
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheExtraOptions(1024,1024,null)
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileCount(100)
                .build();
        ImageLoader.getInstance().init(config);
    }
}
