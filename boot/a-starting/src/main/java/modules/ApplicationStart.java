package modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author 熟知宇某
 * @date 2021/7/28 16:14
 */
@SpringBootApplication
@ComponentScan(basePackages = {"modules"})
public class ApplicationStart extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStart.class);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(ApplicationStart.class, args);
    }
}
