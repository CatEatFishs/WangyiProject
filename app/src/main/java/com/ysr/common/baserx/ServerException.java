package com.ysr.common.baserx;

 /** 服务器请求异常
  *  Created by ysr on 2017/2/3 上午10:13.
  *  邮箱 ysr200808@163.com
  */
public class ServerException extends Exception {

    public ServerException(String msg){
        super(msg);
    }

}
