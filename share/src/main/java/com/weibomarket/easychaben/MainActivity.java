package com.weibomarket.easychaben;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.weibomarket.easychaben.app.ShareDemo;
import com.weibomarket.easychaben.wechat.ShareDemoWeChat;
import com.weibomarket.easychaben.wechat.callbacks.IWeChatSignCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShareDemo.getConfiguration().withActivity(this);
    }

    public void wechatLogin(final View view) {
        ShareDemoWeChat.getInstance().onSignSuccess(new IWeChatSignCallback() {
            @Override
            public void onSignInSuccess(final String userInfo) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, userInfo, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).signIn();

    }
}
