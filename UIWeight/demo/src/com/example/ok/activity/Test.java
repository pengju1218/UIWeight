package com.example.ok.activity;

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
import com.example.ok.R;
import com.example.ok.util.OrderUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.activity_main2);

    }

    @Override
    public void onClick(View v) {

    }
}
