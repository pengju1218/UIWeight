package com.example.ok.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.csdn.Weight.ImageView.RoundImageView;
import com.example.ok.R;
import com.example.ok.util.OrderUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by Administrator on 2016/9/7.
 */
public class RoundImageA extends Activity {
    private ImageLoader imageLoader;
    private RoundImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_image);
        imageLoader = OrderUtil.getInstance().initImageLoader(this, imageLoader, "test");
        imageView=(RoundImageView)findViewById(R.id.userAvater);
        imageLoader.displayImage("http://g.hiphotos.baidu.com/image/h%3D200/sign=c493b482b47eca800d053ee7a1229712/8cb1cb1349540923abd671df9658d109b2de49d7.jpg", imageView);


    }

    public ImageLoader initImageLoader(Context context,
                                       ImageLoader imageLoader, String dirName) {
        imageLoader = ImageLoader.getInstance();
        if (imageLoader.isInited()) {
            // 重新初始化ImageLoader时,需要释放资源.
            imageLoader.destroy();
        }
        imageLoader.init(initImageLoaderConfig(context, dirName));
        return imageLoader;
    }

    /**
     * 配置图片下载器
     *
     * @param dirName 文件名
     */
    private ImageLoaderConfiguration initImageLoaderConfig(
            Context context, String dirName) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                .threadPoolSize(3).memoryCacheSize(getMemoryCacheSize(context))
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .discCache(new UnlimitedDiscCache(new File(dirName)))
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        return config;
    }
    private int getMemoryCacheSize(Context context) {
        int memoryCacheSize;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            int memClass = ((ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE))
                    .getMemoryClass();
            memoryCacheSize = (memClass / 8) * 1024 * 1024; // 1/8 of app memory
            // limit
        } else {
            memoryCacheSize = 2 * 1024 * 1024;
        }
        return memoryCacheSize;
    }
}
