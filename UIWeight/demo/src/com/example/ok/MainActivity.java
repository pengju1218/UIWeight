package com.example.ok;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.csdn.Weight.Dialog.BasicDialogFragment;
import com.csdn.Weight.Dialog.ConfirmDialog;
import com.csdn.Weight.Dialog.GoodAlertDialog;
import com.csdn.Weight.Spinner.ListPopWindow;
import com.csdn.Weight.Spinner.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tvValue;
    private List<String> list;
    private SpinerPopWindow<String> mSpinerPopWindow;
    private TextView tv2;
    private ListPopWindow listPopWindow;
    private String[] strings={"红色","橙色","黄色","绿色","蓝色","紫色","白色","黑色"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvValue = (TextView) findViewById(R.id.tv_value);
        tv2=(TextView)findViewById(R.id.tv2);
        tvValue.setOnClickListener(this);
        initData();
        mSpinerPopWindow = new SpinerPopWindow<String>(this, list, itemClickListener);


        tv2.setOnClickListener(this);
        listPopWindow=new ListPopWindow(this);


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
        }else if(v.getId()==R.id.tv2){
            listPopWindow.setAdatper(list);
            listPopWindow.showPopuponView(tv2);
        }
    }
}
