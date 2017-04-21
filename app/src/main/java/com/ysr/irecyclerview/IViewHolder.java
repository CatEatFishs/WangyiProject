package com.ysr.irecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *  Created by ysr on 2017/2/3 上午11:17.
 *  邮箱 ysr200808@163.com
 */
public abstract class IViewHolder extends RecyclerView.ViewHolder {

   public IViewHolder(View itemView) {
       super(itemView);
   }

   @Deprecated
   public final int getIPosition() {
       return getPosition() - 2;
   }

   public final int getILayoutPosition() {
       return getLayoutPosition() - 2;
   }

   public final int getIAdapterPosition() {
       return getAdapterPosition() - 2;
   }

   public final int getIOldPosition() {
       return getOldPosition() - 2;
   }

   public final long getIItemId() {
       return getItemId();
   }

   public final int getIItemViewType() {
       return getItemViewType();
   }
}
