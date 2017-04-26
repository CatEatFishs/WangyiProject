package com.ysr.fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.ysr.R;
import com.ysr.common.base.BaseFragment;
import com.ysr.common.commonutils.LogUtils;
import com.ysr.myhttp.OKHttpMgr;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by ysr on 2017/4/26 9:20.
 * 邮箱 ysr200808@163.com
 */

public class FocusNewsFragment extends BaseFragment {
    @Bind(R.id.bt_post)
    Button bt_post;
    @Bind(R.id.tv_json)
    TextView tv_json;

    @Override
    protected int getLayoutResource() {
        return R.layout.app_focus_news_fragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_json.setMovementMethod(ScrollingMovementMethod.getInstance());
        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> parms = new HashMap<>();//传递参数
                parms.put("currentPage", "currentPage");
                parms.put("pageSize", "10");
                OKHttpMgr.getAsyn("http://c.m.163.com/nc/video/list/V9LG4B3A0/y/0-10.html", new OKHttpMgr.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        LogUtils.loge("没有数据");
                    }

                    @Override
                    public void onResponse(String u) {
                        tv_json.setText(u.toString());
                        LogUtils.loge("" + u.toString());
                    }
                });
            }
        });
    }
}
