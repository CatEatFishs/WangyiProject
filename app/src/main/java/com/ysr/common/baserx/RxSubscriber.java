package com.ysr.common.baserx;

import android.app.Activity;
import android.content.Context;

import com.ysr.R;
import com.ysr.common.baseapp.BaseApplication;
import com.ysr.common.commonutils.NetWorkUtils;
import com.ysr.common.commonwidget.LoadingDialog;

import rx.Subscriber;


/** 订阅封装
 *  Created by ysr on 2017/2/3 上午10:11.
 *  邮箱 ysr200808@163.com
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {

   private Context mContext;
   private String msg;
   private boolean showDialog=true;

   /**
    * 是否显示浮动dialog
    */
   public void showDialog() {
       this.showDialog= true;
   }
   public void hideDialog() {
       this.showDialog= true;
   }

   public RxSubscriber(Context context, String msg, boolean showDialog) {
       this.mContext = context;
       this.msg = msg;
       this.showDialog=showDialog;
   }
   public RxSubscriber(Context context) {
       this(context, BaseApplication.getAppContext().getString(R.string.loading),true);
   }
   public RxSubscriber(Context context, boolean showDialog) {
       this(context, BaseApplication.getAppContext().getString(R.string.loading),showDialog);
   }

   @Override
   public void onCompleted() {
       if (showDialog)
           LoadingDialog.cancelDialogForLoading();
   }
   @Override
   public void onStart() {
       super.onStart();
       if (showDialog) {
           try {
               LoadingDialog.showDialogForLoading((Activity) mContext,msg,true);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }


   @Override
   public void onNext(T t) {
       _onNext(t);
   }
   @Override
   public void onError(Throwable e) {
       if (showDialog)
           LoadingDialog.cancelDialogForLoading();
       e.printStackTrace();
       //网络
       if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
           _onError(BaseApplication.getAppContext().getString(R.string.no_net));
       }
       //服务器
       else if (e instanceof ServerException) {
           _onError(e.getMessage());
       }
       //其它
       else {
           _onError(BaseApplication.getAppContext().getString(R.string.net_error));
       }
   }

   protected abstract void _onNext(T t);

   protected abstract void _onError(String message);

}
