package com.csdn.Weight.adapter.Base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CommonViewHolder {

    private SparseArray<View> mViews;

    private View mConvertView;


    public CommonViewHolder(Context context, ViewGroup parent, int layoutId) {

        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);

    }

    public static CommonViewHolder get(Context context, View mConvertView, ViewGroup viewGroup, int layoutId) {

        if (mConvertView == null) {
            return new CommonViewHolder(context, viewGroup, layoutId);
        }

        return (CommonViewHolder) mConvertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

   
    public <T extends View> T getView(int viewId, Class<T> tClass) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

}