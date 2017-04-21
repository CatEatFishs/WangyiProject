package com.ysr.irecyclerview.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


/** 左侧划入动画
 *  Created by ysr on 2017/2/3 上午11:08.
 *  邮箱 ysr200808@163.com
 */
public class SlideInLeftAnimation implements BaseAnimation {


 @Override
 public Animator[] getAnimators(View view) {
   return new Animator[] {
       ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().getWidth(), 0)
   };
 }
}
