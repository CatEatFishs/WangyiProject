package com.ysr.photopicker.common;

import java.io.File;
import java.io.Serializable;

/**
 *  Created by ysr on 2017/2/3 下午12:28.
 *  邮箱 ysr200808@163.com
 */
public interface Callback extends Serializable {

   void onSingleImageSelected(String path);

   void onImageSelected(String path);

   void onImageUnselected(String path);

   void onCameraShot(File imageFile);
}
