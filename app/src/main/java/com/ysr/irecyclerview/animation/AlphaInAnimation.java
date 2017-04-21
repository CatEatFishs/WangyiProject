package com.ysr.irecyclerview.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


/** 淡入动画
 *  Created by ysr on 2017/2/3 上午11:08.
 *  邮箱 ysr200808@163.com
 */
public class AlphaInAnimation implements BaseAnimation {

   private static final float DEFAULT_ALPHA_FROM = 0f;
   private final float mFrom;

   public AlphaInAnimation() {
       this(DEFAULT_ALPHA_FROM);
   }

   public AlphaInAnimation(float from) {
       mFrom = from;
   }

   @Override
   public Animator[] getAnimators(View view) {
       return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", mFrom, 1f)};
   }
}
