package com.weibomarket.easychaben.generators;

import com.weibomarket.easychaben.wechat.templates.AppRegisterTemplate;

import cn.heguowen.lib_annotations.annotations.AppRegisterGenerator;


/**
 * @ClassName: ShareProcessor
 * @Description: 自定义注解解析器
 * @Author: heguowen
 * @CreateDate: 2019-10-25 01:07
 */
@AppRegisterGenerator(
        packageName = "com.weibomarket.easychaben",
        registerTemplete= AppRegisterTemplate.class
)
public interface AppRegister {
}
