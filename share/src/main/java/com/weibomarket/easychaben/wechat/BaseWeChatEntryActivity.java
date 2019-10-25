package com.weibomarket.easychaben.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.weibomarket.easychaben.utils.Logutils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * @ClassName: BaseWeChatEntryActivity
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019-07-21 01:19
 */
public abstract class BaseWeChatEntryActivity extends BaseWeChatActivity {
    //用户登录成功后回调
    protected abstract void onSignInSuccess(String userInfo);

    //第三方应用发送请求到微信后的回调
    @Override
    public void onResp(BaseResp baseResp) {
        String code = ((SendAuth.Resp) baseResp).code;
        StringBuilder authUrl = new StringBuilder();
        authUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=")
                .append(ShareDemoWeChat.APP_ID)
                .append("&secret=")
                .append(ShareDemoWeChat.APP_SECRET)
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");
//        Logutils.e("heguowen", authUrl.toString());
//        getAuth(authUrl.toString());
        getAccessToken(authUrl.toString());
    }

    //微信发送请求到第三方应用后的回调
    @Override
    public void onReq(BaseReq baseReq) {
    }

    //https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
    private void getAccessToken(String authUrl) {
        OkHttpClient client = new OkHttpClient();
        //构造Request对象
        //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
        Request request = new Request.Builder().get().url(authUrl).build();
        Call call = client.newCall(request);
        //异步调用并设置回调函数
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseStr = response.body().string();
                JSONObject jsonObject = JSON.parseObject(responseStr);
                Logutils.json("heguowen", responseStr);
                String refreshToken = jsonObject.getString("refresh_token");
                String openId = jsonObject.getString("openid");

                StringBuilder sb = new StringBuilder();
                sb.append("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=")
                        .append(ShareDemoWeChat.APP_ID)
                        .append("&grant_type=refresh_token")
                        .append("&refresh_token=")
                        .append(refreshToken);

                Logutils.d(sb.toString());
                refreshToken(sb.toString());

            }
        });

    }

    //https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
    private void refreshToken(String authUrl) {

        OkHttpClient client = new OkHttpClient();
        //构造Request对象
        //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
        Request request = new Request.Builder().get().url(authUrl).build();
        Call call = client.newCall(request);
        //异步调用并设置回调函数
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseStr = response.body().string();
                JSONObject jsonObject = JSON.parseObject(responseStr);
                Logutils.json("heguowen", responseStr);

                String accessToken = jsonObject.getString("access_token");
                String openId = jsonObject.getString("openid");


                StringBuilder sb = new StringBuilder();
                sb.append("https://api.weixin.qq.com/sns/auth?access_token=")
                        .append(accessToken)
                        .append("&openid=")
                        .append(openId);

                Logutils.d(sb.toString());
                getAuth(sb.toString(), accessToken, openId);

            }
        });
    }


    private void getAuth(String authUrl, final String accessToken, final String openId) {
        OkHttpClient client = new OkHttpClient();
        //构造Request对象
        //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
        Request request = new Request.Builder().get().url(authUrl).build();
        Call call = client.newCall(request);
        //异步调用并设置回调函数
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                StringBuilder sb = new StringBuilder();
                sb.append("https://api.weixin.qq.com/sns/userinfo?access_token=")
                        .append(accessToken)
                        .append("&openid=")
                        .append(openId);

                Logutils.d(sb.toString());
                getUserInfo(sb.toString());

            }
        });
    }

    protected void getUserInfo(String userInfoUrl) {

        OkHttpClient client = new OkHttpClient();
        //构造Request对象
        //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
        Request request = new Request.Builder().get().url(userInfoUrl).build();
        Call call = client.newCall(request);
        //异步调用并设置回调函数
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                onSignInSuccess(response.body().string());
                Logutils.d(response);
            }
        });
    }


}
