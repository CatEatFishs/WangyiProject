package com.ysr.irecyclerview.universaladapter.recyclerview;

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}