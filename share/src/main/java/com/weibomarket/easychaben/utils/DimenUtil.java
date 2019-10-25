package com.weibomarket.easychaben.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.weibomarket.easychaben.app.ShareDemo;


/**
 * @ClassName: DimenUtil
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/11 17:00
 */
public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = ShareDemo.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = ShareDemo.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
