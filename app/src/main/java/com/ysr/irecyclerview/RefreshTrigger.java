package com.ysr.irecyclerview;

 /**
  *  Created by ysr on 2017/2/3 上午11:18.
  *  邮箱 ysr200808@163.com
  */
public interface RefreshTrigger {

    void onStart(boolean automatic, int headerHeight, int finalHeight);

    void onMove(boolean finished, boolean automatic, int moved);

    void onRefresh();

    void onRelease();

    void onComplete();

    void onReset();
}
