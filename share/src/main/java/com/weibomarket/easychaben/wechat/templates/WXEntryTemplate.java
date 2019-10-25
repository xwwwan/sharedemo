package com.weibomarket.easychaben.wechat.templates;

import android.os.Bundle;
import android.support.annotation.Nullable;


import com.weibomarket.easychaben.wechat.BaseWeChatEntryActivity;
import com.weibomarket.easychaben.wechat.ShareDemoWeChat;


/**
 * @ClassName: WXEntryTemplate
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019-07-21 00:44
 */
public class WXEntryTemplate extends BaseWeChatEntryActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        ShareDemoWeChat.getInstance().getSignSuccessCallback().onSignInSuccess(userInfo);
    }
}
