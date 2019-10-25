package com.weibomarket.easychaben.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * @ClassName: BaseWeChatActivity
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019-07-21 01:16
 */
public abstract class BaseWeChatActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShareDemoWeChat.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        ShareDemoWeChat.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }
}
