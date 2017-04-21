package com.ysr.common.commonwidget;

import android.view.View;

import java.util.Calendar;

/** 防止重复点击
 *  Created by ysr on 2017/2/3 上午10:21.
 *  邮箱 ysr200808@163.com
 */

public abstract class OnNoDoubleClickListener implements View.OnClickListener {

   public static final int MIN_CLICK_DELAY_TIME = 1000;
   private long lastClickTime = 0;

   @Override
   public void onClick(View v) {
       long currentTime = Calendar.getInstance().getTimeInMillis();
       if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
           lastClickTime = currentTime;
           onNoDoubleClick(v);
       }
   }

   protected abstract void onNoDoubleClick(View v);

}