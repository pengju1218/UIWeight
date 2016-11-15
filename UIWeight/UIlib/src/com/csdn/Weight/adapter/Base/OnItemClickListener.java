package com.csdn.Weight.adapter.Base;

public interface OnItemClickListener <T> {

    /**
     * 点击事件分发
     * @param item
     * @param viewId
     * @param position
     */
    void onItemClick(T item,int viewId,int position);

}