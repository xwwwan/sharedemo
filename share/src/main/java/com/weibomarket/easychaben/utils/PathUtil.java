package com.weibomarket.easychaben.utils;

import android.os.Environment;

import java.io.File;

/**
 * @ClassName: PathUtil
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/11 23:32
 */
public class PathUtil {

    public static final String DOWNLOAD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "zcb";
}
