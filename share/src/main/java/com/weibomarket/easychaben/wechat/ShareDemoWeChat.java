package com.weibomarket.easychaben.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.weibomarket.easychaben.app.ConfigType;
import com.weibomarket.easychaben.app.ShareDemo;
import com.weibomarket.easychaben.wechat.callbacks.IWeChatSignCallback;

/**
 * @ClassName: ShareDemoWeChat
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019-07-21 01:00
 */
public class ShareDemoWeChat {
    public static final String APP_ID ="wxb46aa5a311b637b1";
    public static final String APP_SECRET = "af57cbf8905e428ed68574619996a3e9";
    private IWeChatSignCallback mSignSuccessCallback;
    private final IWXAPI WXAPI;


    private ShareDemoWeChat() {
        final Activity activity = ShareDemo.getConfiguration(ConfigType.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public static ShareDemoWeChat getInstance() {
        return Holder.INSTANCE;
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public ShareDemoWeChat onSignSuccess(IWeChatSignCallback callback) {
        this.mSignSuccessCallback = callback;
        return this;
    }

    public IWeChatSignCallback getSignSuccessCallback() {
        return mSignSuccessCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        WXAPI.sendReq(req);
    }

    private static final class Holder {
        private static final ShareDemoWeChat INSTANCE = new ShareDemoWeChat();
    }
}
