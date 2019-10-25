package com.weibomarket.easychaben.icon;

import com.joanzapata.iconify.Icon;

/**
 * @ClassName: GDZCBIcons
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019/7/11 00:31
 */
public enum GDZCBIcons implements Icon {
    icon_scan('a'),
    icon_ali_pay('a');

    private char character;

    GDZCBIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }


}
