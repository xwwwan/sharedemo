package com.weibomarket.easychaben.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


import com.wang.avi.AVLoadingIndicatorView;
import com.weibomarket.easychaben.R;
import com.weibomarket.easychaben.utils.DimenUtil;

import java.util.ArrayList;


/**
 * @ClassName: QianMoLoader
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/11 16:47
 */
public class QianMoLoader {

    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_SIZE_HEIGHT_OFFSET = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    private static final String DEFAULT_LOADER =   LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, Enum<  LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView =   LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        int screenWidth = DimenUtil.getScreenWidth();
        int screenHeight = DimenUtil.getScreenHeight();
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = screenWidth / LOADER_SIZE_SCALE;
            layoutParams.height = layoutParams.height + screenHeight / LOADER_SIZE_HEIGHT_OFFSET;
            layoutParams.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }


}
