package com.csdn.Weight.adapter.Base;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.csdn.Weight.R;

import java.util.List;


public abstract class CommonAdapter<T> extends BaseAdapter {

    private List<T> mDataList;

    private Activity context;

    private int layoutId;

    public OnItemClickListener itemClickListener;

    public CommonAdapter(Activity context, List<T> mDataList, int layoutId) {
        this.mDataList = mDataList;
        this.context = context;
        this.layoutId = layoutId;
    }


    @Override
    public int getCount() {
        return null == mDataList ? 0 : mDataList.size();
    }

    @Override
    public T getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final CommonViewHolder commonViewHolder = CommonViewHolder.get(context, convertView, parent, layoutId);
        View view = commonViewHolder.getConvertView();
        resetView(position, commonViewHolder, getItem(position));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {

                    itemClickListener.onItemClick(getItem(position), layoutId, position);
                }
            }
        });
        return view;
    }

    public abstract void resetView(int position, CommonViewHolder viewHolder, T item);


    public void updateData(List<T> data) {

        this.mDataList = data;
        notifyDataSetChanged();
    }

    public void setOnitemClickListenr(OnItemClickListener<T> onitemClickListenr) {

        this.itemClickListener = onitemClickListenr;
    }

    public List<T> getListData() {

        return mDataList;
    }

    public Activity getContext() {

        return context;
    }


}