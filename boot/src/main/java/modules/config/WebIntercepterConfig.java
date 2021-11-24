package modules.config;

import modules.intercepter.DemoIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 熟知宇某
 * @date 2021/7/30 14:59
 */
@Configuration
public class WebIntercepterConfig implements WebMvcConfigurer {

    @Autowired
    DemoIntercepter demoIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoIntercepter).addPathPatterns("/demo/**");
    }
}
