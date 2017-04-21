package com.ysr.common.commonutils;

import java.text.DecimalFormat;

/** 金钱
 *  Created by ysr on 2017/2/3 上午10:18.
 *  邮箱 ysr200808@163.com
 */
public class MoneyUtil {
   public static String MoneyFomatWithTwoPoint(double d){
       DecimalFormat df = new DecimalFormat("#.##");
       return df.format(d);
   }
}
