package com.csdn.Weight.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.csdn.Weight.R;
import com.csdn.Weight.util.Otin;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class GoodAlertDialog {

    private AlertDialog alertDialog;

    public GoodAlertDialog(Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.confirm_dialog, null);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setGravity(Gravity.CENTER);
        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        WindowManager.LayoutParams layoutParams = alertDialog.getWindow().getAttributes();
        layoutParams.width = Otin.getThis().dip2px(context, 500);
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        alertDialog.getWindow().setAttributes(layoutParams);
        alertDialog.setContentView(view);

    }


    public void show() {
        alertDialog.show();
    }

}
