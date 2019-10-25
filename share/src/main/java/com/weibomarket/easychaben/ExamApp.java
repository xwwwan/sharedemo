package com.weibomarket.easychaben;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.weibomarket.easychaben.app.ShareDemo;


/**
 * @ClassName: ExamApp
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/10 23:45
 */
public class ExamApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ShareDemo.init(this)
                .withWeChatAppId("wxb46aa5a311b637b1")
                .withWeChatAppSecret("af57cbf8905e428ed68574619996a3e9")
                .configure();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
