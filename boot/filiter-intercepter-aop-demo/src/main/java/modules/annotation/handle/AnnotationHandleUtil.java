package modules.annotation.handle;

import modules.annotation.DefineParamAnnotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 熟知宇某
 * @date 2021/8/5 14:38
 */
public class AnnotationHandleUtil {
    public static Map getParam(Class<?> clazz){
        HashMap<String, String> paramMap = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();//获取成员变量
        for (Field field : fields) {
            if (field.isAnnotationPresent(DefineParamAnnotation.class)){
                DefineParamAnnotation defineParamAnnotation = field.getAnnotation(DefineParamAnnotation.class);
                paramMap.put("defineParam", defineParamAnnotation.address() + "的" + defineParamAnnotation.name());
            }
        }
        return paramMap;

    }
}
