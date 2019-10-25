package com.weibomarket.easychaben;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.weibomarket.easychaben.app.ShareDemo;
import com.weibomarket.easychaben.icon.FontGDZCBModule;


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
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontGDZCBModule())
                .withApiHost("http://127.0.0.1/")
                .withWeChatAppId("wxb46aa5a311b637b1")
                .withWeChatAppSecret("af57cbf8905e428ed68574619996a3e9")
                .configure();
        Logger.addLogAdapter(new AndroidLogAdapter());
//        Stetho.initializeWithDefaults(this);
    }

//    private void initStetho() {
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
//    }
}
