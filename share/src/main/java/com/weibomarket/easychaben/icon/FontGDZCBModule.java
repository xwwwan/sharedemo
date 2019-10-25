package com.weibomarket.easychaben.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * @ClassName: FontGDZCBModule
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/11 00:28
 */
public class FontGDZCBModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return new Icon[0];
    }
}
