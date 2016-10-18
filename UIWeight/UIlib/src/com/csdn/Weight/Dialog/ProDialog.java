package com.csdn.Weight.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.csdn.Weight.R;

/**
 * Created by Administrator on 2016/10/18.
 */
public class ProDialog extends Dialog {
    public ProDialog(Context context) {
        super(context);
        init(context);
    }

    public ProDialog(Context context, int themeResId) {
        super(context, R.style.progress_dialog);
        init(context);
    }

    protected ProDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }


    public void init(Context context) {
        this.setContentView(R.layout.progress_dialog);
        this.setCancelable(true);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = (TextView) this.findViewById(R.id.id_tv_loadingmsg);
        msg.setText("拼命加载中");

    }


}
