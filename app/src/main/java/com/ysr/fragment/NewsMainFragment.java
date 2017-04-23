package com.ysr.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ysr.R;
import com.ysr.adapter.NewsAdapter;
import com.ysr.common.base.BaseFragment;
import com.ysr.fragment.bean.NewsInfo;
import com.ysr.irecyclerview.IRecyclerView;
import com.ysr.map.LocationActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ysr on 2017/4/22 下午2:12.
 * 邮箱 ysr200808@163.com
 */

public class NewsMainFragment extends BaseFragment implements NewsAdapter.OnNewsCallbackListener {
    @Bind(R.id.irc)
    IRecyclerView irc;
    private NewsAdapter madapter;
    private List<NewsInfo> list;
    private NewsInfo info;

    @Override
    protected int getLayoutResource() {
        return R.layout.app_news_fragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        info = new NewsInfo();
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            info.setTitle("test");
            list.add(info);
        }
        madapter = new NewsAdapter(getActivity(), list);
        madapter.setOnItemClickListener(this);
        irc.setLayoutManager(new LinearLayoutManager(getActivity()));
        irc.setAdapter(madapter);
    }

    @Override
    public void ondelItemClick(View view, int position, NewsInfo info) {
        Intent intent = new Intent(getActivity(), LocationActivity.class);
        startActivity(intent);
    }
}
