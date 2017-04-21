package com.ysr.common.basebean;

import java.io.Serializable;

/** 封装服务器返回数据
 *  Created by ysr on 2017/2/3 上午10:09.
 *  邮箱 ysr200808@163.com
 */
public class BaseRespose <T> implements Serializable {
   public String code;
   public String msg;

   public T data;

   public boolean success() {
       return "1".equals(code);
   }

   @Override
   public String toString() {
       return "BaseRespose{" +
               "code='" + code + '\'' +
               ", msg='" + msg + '\'' +
               ", data=" + data +
               '}';
   }
}
