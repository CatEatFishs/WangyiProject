package com.ysr.common.baserx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/** RxJava调度管理
 *  Created by ysr on 2017/2/3 上午10:11.
 *  邮箱 ysr200808@163.com
 */
public class RxSchedulers {
   public static <T> Observable.Transformer<T, T> io_main() {
       return new Observable.Transformer<T, T>() {
           @Override
           public Observable<T> call(Observable<T> observable) {
               return observable.subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread());
           }
       };
   }
}
