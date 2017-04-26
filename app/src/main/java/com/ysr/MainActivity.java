package com.ysr;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ysr.app.AppConstant;
import com.ysr.app.bean.TabEntity;
import com.ysr.common.base.BaseActivity;
import com.ysr.common.daynightmodeutils.ChangeModeController;
import com.ysr.fragment.FocusNewsFragment;
import com.ysr.fragment.NewsMainFragment;

import java.util.ArrayList;

import butterknife.Bind;
import rx.functions.Action1;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"新闻", "要闻","视频","我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal,R.mipmap.ic_girl_normal,R.mipmap.ic_video_normal,R.mipmap.ic_care_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected,R.mipmap.ic_girl_selected, R.mipmap.ic_video_selected,R.mipmap.ic_care_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private static int tabLayoutHeight;
    private NewsMainFragment newsMainFragment;
    private FocusNewsFragment newsMainFragment2;
    private NewsMainFragment newsMainFragment3;
    private NewsMainFragment newsMainFragment4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //切换daynight模式要立即变色的页面
        ChangeModeController.getInstance().init(this,R.attr.class);
        super.onCreate(savedInstanceState);
        //初始化frament
        initFragment(savedInstanceState);
        tabLayout.measure(0,0);
        tabLayoutHeight=tabLayout.getMeasuredHeight();
        //监听菜单显示或隐藏
        mRxManager.on(AppConstant.MENU_SHOW_HIDE, new Action1<Boolean>() {

            @Override
            public void call(Boolean hideOrShow) {
                startAnimation(hideOrShow);
            }
        });
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        //初始化菜单
        initTab();

    }
    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
    }
    /**
     * 初始化碎片
     */
    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            newsMainFragment = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment");
            newsMainFragment2 = (FocusNewsFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment2");
            newsMainFragment3 = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment3");
            newsMainFragment4 = (NewsMainFragment) getSupportFragmentManager().findFragmentByTag("newsMainFragment4");
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            newsMainFragment = new NewsMainFragment();
            newsMainFragment2 = new FocusNewsFragment();
            newsMainFragment3 = new NewsMainFragment();
            newsMainFragment4 = new NewsMainFragment();

            transaction.add(R.id.fl_body, newsMainFragment, "newsMainFragment");
            transaction.add(R.id.fl_body, newsMainFragment2, "newsMainFragment2");
            transaction.add(R.id.fl_body, newsMainFragment3, "newsMainFragment3");
            transaction.add(R.id.fl_body, newsMainFragment4, "newsMainFragment4");
        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }


    }
    /**
     * 菜单显示隐藏动画
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide){
        final ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if(!showOrHide){
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 1, 0);
        }else{
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height= (int) valueAnimator.getAnimatedValue();
                tabLayout.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator,alpha);
        animatorSet.start();
    }
    /**
     * 切换
     */
    private void SwitchTo(int position) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            //新闻
            case 0:
                transaction.hide(newsMainFragment4);
                transaction.hide(newsMainFragment3);
                transaction.hide(newsMainFragment2);
                transaction.show(newsMainFragment);
                transaction.commitAllowingStateLoss();
                break;
            //要闻
            case 1:
                transaction.hide(newsMainFragment);
                transaction.hide(newsMainFragment3);
                transaction.hide(newsMainFragment4);
                transaction.show(newsMainFragment2);
                transaction.commitAllowingStateLoss();
                break;
            //视频
            case 2:
                transaction.hide(newsMainFragment);
                transaction.hide(newsMainFragment2);
                transaction.hide(newsMainFragment4);
                transaction.show(newsMainFragment3);
                transaction.commitAllowingStateLoss();
                break;
            //我的
            case 3:
                transaction.hide(newsMainFragment);
                transaction.hide(newsMainFragment2);
                transaction.hide(newsMainFragment3);
                transaction.show(newsMainFragment4);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }
}
