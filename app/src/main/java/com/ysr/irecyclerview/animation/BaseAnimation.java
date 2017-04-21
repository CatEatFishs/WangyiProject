package com.ysr.irecyclerview.animation;

import android.animation.Animator;
import android.view.View;

/** 基本动画
 *  Created by ysr on 2017/2/3 上午11:08.
 *  邮箱 ysr200808@163.com
 */
public interface  BaseAnimation {

   Animator[] getAnimators(View view);

}
