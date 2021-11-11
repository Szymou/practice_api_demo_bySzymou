package modules.controller;

import modules.annotation.DemoAnnotation;
import modules.annotation.handle.AnnotationHandleUtil;
import modules.entity.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 熟知宇某
 * @date 2021/7/28 16:10
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @DemoAnnotation
    @RequestMapping("helloWorld")
    public String helloWorld(){
        System.out.println("接口的动作");
        return "helloWorld";
    }

    @RequestMapping("testAnnotation")
    public String testAnnotation(){
        Map map = AnnotationHandleUtil.getParam(UserInfoDTO.class);
        System.out.println(map.toString());
        return map.toString();
    }

}
