package com.weibomarket.easychaben.generators;

import com.weibomarket.easychaben.wechat.templates.WXEntryTemplate;

import cn.heguowen.lib_annotations.annotations.EntryGenerator;

/**
 * @ClassName: WeCartEntry
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019-07-21 00:46
 */
@EntryGenerator(
        packageName = "com.weibomarket.easychaben",
        entryTemplete= WXEntryTemplate.class
)
public interface WeCartEntry {
}
