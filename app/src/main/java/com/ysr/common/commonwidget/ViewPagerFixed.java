package com.ysr.common.commonwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/** 修复viewpager
 *  Created by ysr on 2017/2/3 上午10:21.
 *  邮箱 ysr200808@163.com
 */
public class ViewPagerFixed extends android.support.v4.view.ViewPager {

   public ViewPagerFixed(Context context) {
       super(context);
   }

   public ViewPagerFixed(Context context, AttributeSet attrs) {
       super(context, attrs);
   }

   @Override
   public boolean onTouchEvent(MotionEvent ev) {
       try {
           return super.onTouchEvent(ev);
       } catch (IllegalArgumentException ex) {
           ex.printStackTrace();
       }
       return false;
   }

   @Override
   public boolean onInterceptTouchEvent(MotionEvent ev) {
       try {
           return super.onInterceptTouchEvent(ev);
       } catch (IllegalArgumentException ex) {
           ex.printStackTrace();
       }
       return false;
   }
}
