package com.example.ok;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.csdn.Weight.Button.TimeButton;
import com.csdn.Weight.Dialog.BasicDialogFragment;
import com.csdn.Weight.Dialog.ConfirmDialog;
import com.csdn.Weight.Dialog.GoodAlertDialog;
import com.csdn.Weight.Dialog.LayDialog;
import com.csdn.Weight.ImageView.RoundImageView;
import com.csdn.Weight.Spinner.ListPopWindow;
import com.csdn.Weight.Spinner.SpinerPopWindow;
import com.example.ok.util.OrderUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tvValue;
    private List<String> list;
    private SpinerPopWindow<String> mSpinerPopWindow;
    private TextView tv2;
    private ListPopWindow listPopWindow;
    private String[] strings = {"红色", "橙色", "黄色", "绿色", "蓝色", "紫色", "白色", "黑色"};
    private ImageLoader imageLoader;
    private RoundImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.activity_main);

        tvValue = (TextView) findViewById(R.id.tv_value);
        tv2 = (TextView) findViewById(R.id.tv2);
        tvValue.setOnClickListener(this);
        initData();
        mSpinerPopWindow = new SpinerPopWindow<String>(this, list, itemClickListener);


        tv2.setOnClickListener(this);
        listPopWindow = new ListPopWindow(this);
        imageLoader = OrderUtil.getInstance().initImageLoader(this, imageLoader, "test");
        imageView=(RoundImageView)findViewById(R.id.userAvater);
        imageLoader.displayImage("http://img4.imgtn.bdimg.com/it/u=98923187,3761999633&fm=11&gp=0.jpg", imageView);

      final   TimeButton btn = (TimeButton) findViewById(R.id.timeButton);
        btn.setTextBefore("点击获取验证码").setTextAfter("秒后重新获取").setLenght(10 * 1000);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.start();
            }
        });
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
    /**
     * popupwindow显示的ListView的item点击事件
     */
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mSpinerPopWindow.dismiss();
            tvValue.setText(list.get(position));
            Toast.makeText(MainActivity.this, "点击了:" + list.get(position), Toast.LENGTH_LONG).show();
        }
    };

    public void showConfirm(View view) {
        Exit(this);
    }

    public void showOther(View view) {

        LayDialog layDialog = new LayDialog(this, R.style.OtherDilaog);
        layDialog.show();
    }

    public void Exit(final Context context) {
        final ConfirmDialog confirmDialog = new ConfirmDialog(context, "确定要退出吗?", "退出", "取消");
        confirmDialog.show();
        confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {
            @Override
            public void doConfirm() {
                // TODO Auto-generated method stub
                confirmDialog.dismiss();
                //toUserHome(context);

            }

            @Override
            public void doCancel() {
                // TODO Auto-generated method stub
                confirmDialog.dismiss();
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list.add("test:" + i);
        }
    }

    public void showAlert(View view) {

        GoodAlertDialog goodAlertDialog = new GoodAlertDialog(this);
        //goodAlertDialog.show();
    }

    public void buttonClick(View view) {
        showDialog();
    }

    private void showDialog() {

        /**
         * 为了不重复显示dialog，在显示对话框之前移除正在显示的对话框。
         */
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("Two");
        if (null != fragment) {
            ft.remove(fragment);
        }

        /**
         * 0:默认样式
         * 1：无标题样式
         * 2：无边框样式
         * 3：不可输入，不可获得焦点样式
         * 可根据参数不同执行测试这几种样式的对话框。
         */
        BasicDialogFragment dialogFragment = BasicDialogFragment.newInstance(1);
        dialogFragment.show(ft, "Two");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_value) {
            mSpinerPopWindow.show(tvValue);
        } else if (v.getId() == R.id.tv2) {
            listPopWindow.setAdatper(list);
            listPopWindow.showPopuponView(tv2);
        }
    }
}
