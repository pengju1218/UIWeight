package com.csdn.Weight.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.csdn.Weight.R;

/**
 * Created by Administrator on 2016/8/3.
 */
public class LayDialog extends Dialog {


    public LayDialog(Context context) {
        super(context);

    }

    public LayDialog(Context context, int themeResId) {
        super(context, themeResId);
        View view = View.inflate(context, R.layout.other_dialog, null);
        setContentView(view);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.getDecorView().setPadding(100, 0, 100, 0);
       /* params.x = 0; // 新位置X坐标
        params.y = 0; // 新位置Y坐标
        params.width = width; // 宽度
        params.height = height; // 高度*/
       // window.setBackgroundDrawableResource(R.drawable.other_bg);
        window.setAttributes(params);


    }


}
