package com.ysr.common.base;

 /** baseview
  *  Created by ysr on 2017/2/3 上午10:07.
  *  邮箱 ysr200808@163.com
  */
public interface BaseView {
    /*******内嵌加载*******/
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
