package com.weibomarket.easychaben.app;

import android.content.Context;

/**
 * @ClassName: ShareDemo
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/10 23:44
 */
@SuppressWarnings("JavaDoc")
public final class ShareDemo {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getQianmoConfigs()
                .put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfiguration() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfiguration().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration().getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

}
