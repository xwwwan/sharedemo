package com.weibomarket.easychaben.generators;


import com.weibomarket.easychaben.wechat.templates.WXPayTemplate;

import cn.heguowen.lib_annotations.annotations.PayEntryGenerator;

/**
 * @ClassName: WeCartEntry
 * @Description: java类作用描述
 * @Author: heguowen
 * @CreateDate: 2019-07-21 00:46
 */
@PayEntryGenerator(
        packageName = "com.weibomarket.easychaben",
        payEntryTemplete= WXPayTemplate.class
)
public interface WeCartPayEntry {
}
