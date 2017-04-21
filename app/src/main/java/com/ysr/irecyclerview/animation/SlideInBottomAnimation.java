package com.ysr.irecyclerview.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


/** 底部划入动画
 *  Created by ysr on 2017/2/3 上午11:08.
 *  邮箱 ysr200808@163.com
 */
public class SlideInBottomAnimation implements BaseAnimation {



   @Override
   public Animator[] getAnimators(View view) {
       return new Animator[]{
               ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0)
       };
   }
}
