package com.ysr.common.base;

import android.content.Context;

import com.ysr.common.baserx.RxManager;

/** 基类presenter
 *  Created by ysr on 2017/2/3 上午10:07.
 *  邮箱 ysr200808@163.com
 */
public abstract class BasePresenter<T,E>{
   public Context mContext;
   public E mModel;
   public T mView;
   public RxManager mRxManage = new RxManager();

   public void setVM(T v, E m) {
       this.mView = v;
       this.mModel = m;
       this.onStart();
   }
   public void onStart(){
   }
   public void onDestroy() {
       mRxManage.clear();
   }
}
