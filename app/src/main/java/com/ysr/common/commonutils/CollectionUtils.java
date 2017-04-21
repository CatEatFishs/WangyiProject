package com.ysr.common.commonutils;

import java.util.Collection;

/** 集合操作工具类
 *  Created by ysr on 2017/2/3 上午10:13.
 *  邮箱 ysr200808@163.com
 */
public class CollectionUtils {

   /**
    * 判断集合是否为null或者0个元素
    *
    * @param c
    * @return
    */
   public static boolean isNullOrEmpty(Collection c) {
       if (null == c || c.isEmpty()) {
           return true;
       }
       return false;
   }
}
