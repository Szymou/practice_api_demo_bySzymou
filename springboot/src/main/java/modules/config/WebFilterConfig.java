package modules.config;

import modules.filter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author 熟知宇某
 * @date 2021/7/30 15:33
 */
@Component
public class WebFilterConfig {

    @Bean
    @Primary
    public FilterRegistrationBean<DemoFilter> filterRegistrationBean(){
        System.out.println("注册过滤器");
        FilterRegistrationBean<DemoFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new DemoFilter());
//        filterRegistrationBean.addUrlPatterns("/demo/*");
        filterRegistrationBean.setName("myFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}
