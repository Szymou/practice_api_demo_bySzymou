package modules.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 熟知宇某
 * @date 2021/8/5 14:33
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface DefineParamAnnotation {
    public String name() default "cyh";
    public String address() default "亿锋";
}
