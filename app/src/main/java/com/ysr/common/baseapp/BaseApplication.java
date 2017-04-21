package com.ysr.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import com.ysr.BuildConfig;
import com.ysr.app.EntityInfo;
import com.ysr.common.commonutils.LogUtils;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    private EntityInfo entity;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;

        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }

    public static Context getAppContext() {
        if (null == baseApplication) {
            throw new RuntimeException("必须先实例化Application");
        }
        return baseApplication;
    }

    public static BaseApplication getInstance() {
        if (null == baseApplication) {
            throw new RuntimeException("必须先实例化Application");
        }
        return baseApplication;
    }

    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public EntityInfo getInfo() {
        if (entity == null) {
            entity = new EntityInfo();
        }
        return entity;
    }

    public void setInfo(EntityInfo entity) {
        this.entity = entity;
    }
}
