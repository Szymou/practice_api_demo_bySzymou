package modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author 熟知宇某
 * @date 2021/7/28 16:14
 */
@SpringBootApplication
public class ApplicationStart extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStart.class);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(ApplicationStart.class, args);
    }
}
