package com.ysr.photopicker.common;


import com.ysr.photopicker.bean.Image;

/**
  *  Created by ysr on 2017/2/3 下午12:28.
  *  邮箱 ysr200808@163.com
  */
public interface OnItemClickListener {

    void onClick(int position, Image image);
}
