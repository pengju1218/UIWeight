package com.csdn.Weight.util;

import android.content.Context;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class Otin {
    public static Otin otin;

    public static  Otin getThis(){
        if(otin==null){
            otin=new Otin();
        }
        return otin;
    }


    public  int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    public  int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}
