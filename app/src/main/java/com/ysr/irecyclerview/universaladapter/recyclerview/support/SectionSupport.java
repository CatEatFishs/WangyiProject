package com.ysr.irecyclerview.universaladapter.recyclerview.support;

/**
 * Created by ysr on 2017/2/3 上午11:13.
 * 邮箱 ysr200808@163.com
 */
public interface SectionSupport<T> {
    public int sectionHeaderLayoutId();

    public int sectionTitleTextViewId();

    public String getTitle(T t);
}
