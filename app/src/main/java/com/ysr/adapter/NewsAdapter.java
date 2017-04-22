package com.ysr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysr.R;
import com.ysr.fragment.bean.NewsInfo;

import java.util.List;

/**
 * Created by ysr on 2017/4/22 下午2:33.
 * 邮箱 ysr200808@163.com
 */

public class NewsAdapter extends RecyclerView.Adapter {
    private List<NewsInfo> list;
    private Context context;
    private OnNewsCallbackListener mOnRecyclerViewItemClickLsitener;

    public NewsAdapter(Context context, List<NewsInfo> list) {
        this.list = list;
        this.context = context;
    }

    public void update(List<NewsInfo> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.irc_mode_news_list_item, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).getTitle().setText(list.get(position).getTitle());
        if (mOnRecyclerViewItemClickLsitener != null) {
            final int adjPosition = position;
            ((MyViewHolder) holder).iv_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object tag = v.getTag();
                    if (tag instanceof NewsInfo) {
                        mOnRecyclerViewItemClickLsitener.ondelItemClick(holder.itemView, adjPosition, (NewsInfo) tag);
                    }

                }
            });


            NewsInfo one = list.get(adjPosition);
            if (null != one) {
                ((MyViewHolder) holder).iv_del.setTag(one);

            }

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView iv_del;


        public MyViewHolder(View itemView) {
            super(itemView);
            iv_del = (ImageView) itemView.findViewById(R.id.iv_del);
            title = (TextView) itemView.findViewById(R.id.tvTopicdesc);
        }

        public TextView getTitle() {
            return title;
        }

    }

    public void setOnItemClickListener(OnNewsCallbackListener mListener) {
        this.mOnRecyclerViewItemClickLsitener = mListener;
    }
    public interface OnNewsCallbackListener {

        void ondelItemClick(View view, int position, NewsInfo info);

    }
}
