package com.weibomarket.easychaben.app;

import android.app.Activity;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * @ClassName: Configurator
 * @Description: 全局配置管理类
 * @Author: heguowen
 * @CreateDate: 2019/7/10 23:46
 */
@SuppressWarnings("JavaDoc")
public class Configurator {
    private static final HashMap<Object, Object> QIANMO_CONFIGS = new HashMap<>();

    private Configurator() {
        QIANMO_CONFIGS.put(ConfigType.CONFIG_READY, false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public HashMap<Object, Object> getQianmoConfigs() {
        return QIANMO_CONFIGS;
    }

    public final void configure() {
        QIANMO_CONFIGS.put(ConfigType.CONFIG_READY, true);
    }

    public final Configurator withWeChatAppId(String appId) {
        QIANMO_CONFIGS.put(ConfigType.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String weChatAppSecret) {
        QIANMO_CONFIGS.put(ConfigType.WE_CHAT_APP_SECRET, weChatAppSecret);
        return this;
    }

    public final Configurator withActivity(Activity activity) {
        QIANMO_CONFIGS.put(ConfigType.ACTIVITY, activity);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) QIANMO_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure!");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        return (T) QIANMO_CONFIGS.get(key);

    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }
}
