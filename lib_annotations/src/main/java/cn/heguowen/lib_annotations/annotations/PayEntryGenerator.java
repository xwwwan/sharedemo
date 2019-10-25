package cn.heguowen.lib_annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: PayEntryGenerator
 * @Description: 支付自定义注解
 * @Author: heguowen
 * @CreateDate: 2019-10-25 00:57
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface PayEntryGenerator {
    String packageName();

    Class<?> payEntryTemplete();
}
