package com.ysr.common.commonwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/** 不会滚动的listview
 *  Created by ysr on 2017/2/3 上午10:21.
 *  邮箱 ysr200808@163.com
 */

public class NoScrollListview extends ListView {
   public NoScrollListview(Context context) {
       super(context);
       // TODO Auto-generated constructor stub
   }
   public NoScrollListview(Context context, AttributeSet attrs) {
       super(context, attrs);
   }
   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
               MeasureSpec.AT_MOST);
       super.onMeasure(widthMeasureSpec, expandSpec);
   }
}