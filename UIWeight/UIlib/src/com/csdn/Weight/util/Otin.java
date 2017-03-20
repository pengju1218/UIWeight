package com.csdn.Weight.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class Otin {
    public static Otin otin;

    public static Otin getThis() {
        if (otin == null) {
            otin = new Otin();
        }
        return otin;
    }


    public int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public Point getRealSize(Context context) {
        Point point = new Point();
        ((Activity) context).getWindowManager().getDefaultDisplay().getRealSize(point);
        return point;
    }
}
