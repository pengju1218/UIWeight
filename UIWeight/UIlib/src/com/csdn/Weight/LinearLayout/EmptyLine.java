package com.csdn.Weight.LinearLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csdn.Weight.Dialog.ProDialog;
import com.csdn.Weight.R;
import com.csdn.Weight.util.Otin;

/**
 * Created by Administrator on 2016/10/18.
 */
public class EmptyLine extends LinearLayout {

    private ProDialog proDialog;

    public EmptyLine(Context context) {
        super(context);
        init(context);
    }

    public EmptyLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmptyLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context) {

        proDialog = new ProDialog(context, R.style.progress_dialog);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(params);
        this.setOrientation(VERTICAL);
        this.setBackgroundColor(context.getResources().getColor(R.color.empty_color));


        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams img_prarms = new LinearLayout.LayoutParams(Otin.getThis().dip2px(context, 160),
                Otin.getThis().dip2px(context, 110));
        img_prarms.gravity = Gravity.CENTER;
        img_prarms.setMargins(0, Otin.getThis().dip2px(context, 70), 0, 0);
        imageView.setLayoutParams(img_prarms);
        imageView.setImageResource(R.drawable.nonet);
        this.addView(imageView);

        TextView txt1 = new TextView(context);
        LinearLayout.LayoutParams txt1_prarms = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                Otin.getThis().dip2px(context, 30));
        txt1_prarms.gravity = Gravity.CENTER_HORIZONTAL;
        txt1.setLayoutParams(txt1_prarms);
        txt1.setTextColor(Color.parseColor("#333333"));
        txt1.setText("网络出问题了");
        txt1.setTextSize(12);
        this.addView(txt1);


        TextView txt2 = new TextView(context);
        LinearLayout.LayoutParams txt2_prarms = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                Otin.getThis().dip2px(context, 30));
        txt2_prarms.gravity = Gravity.CENTER_HORIZONTAL;
        txt2.setLayoutParams(txt2_prarms);
        txt2.setTextColor(Color.parseColor("#767676"));
        txt2.setText("网络或服务出现问题，刷新试试吧");
        txt2.setTextSize(12);
        this.addView(txt2);

        Button button = new Button(context);
        LinearLayout.LayoutParams bu_prarms = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                Otin.getThis().dip2px(context, 36));
        bu_prarms.gravity = Gravity.CENTER;
        button.setPadding(Otin.getThis().dip2px(context, 10), 0, Otin.getThis().dip2px(context, 10), 0);
        button.setLayoutParams(bu_prarms);
        button.setTextColor(Color.parseColor("#333333"));
        button.setText("刷新一下试试");
        button.setTextSize(14);
        button.setBackgroundResource(R.drawable.empty_bu_bg);
        this.addView(button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                proDialog.show();
                EmptyLine.this.setVisibility(GONE);
                if (onSendDataListener != null) {
                    onSendDataListener.send();
                }
            }
        });
    }
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                proDialog.dismiss();
            }
        }
    };
    public void setProGone(){

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },200);

    }
    private OnSendDataListener onSendDataListener;

    public void setOnSendDataListener(OnSendDataListener onSendDataListener) {
        this.onSendDataListener = onSendDataListener;
    }

    public interface OnSendDataListener {
        public void send();
    }

}
