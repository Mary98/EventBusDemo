package com.mary.eventbusdemo;

import android.app.Activity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * File Name:
 * Author:      Mary
 * Write Dates: 16/7/31
 * Description:
 * Change log:
 * 16/7/31-09-15---[公司]---[姓名]
 * ......Added|Changed|Delete......
 * --------------------------------
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    /**
     * EventBus(3.0.0)需要在每个注册后的Activity至少有一个【public权限、有注解、有返回参数】的方法
     * @param object    返回参数
     */
    @Subscribe
    public void notDispatchEventBus(Object object) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

