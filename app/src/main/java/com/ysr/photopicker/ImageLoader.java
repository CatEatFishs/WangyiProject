package com.ysr.photopicker;

import android.content.Context;
import android.widget.ImageView;

import java.io.Serializable;

/**
 *  Created by ysr on 2017/2/3 下午12:04.
 *  邮箱 ysr200808@163.com
 */
public interface ImageLoader extends Serializable {
   void displayImage(Context context, String path, ImageView imageView);
}