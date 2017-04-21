package com.ysr;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.ysr.common.base.BaseActivity;
import com.ysr.irecyclerview.IRecyclerView;

import butterknife.Bind;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.tv)
    TextView tv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        irc.setLayoutManager(new LinearLayoutManager(mContext));
        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:

                break;
        }


    }
}
