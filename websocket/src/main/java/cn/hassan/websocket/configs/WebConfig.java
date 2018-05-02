package cn.hassan.websocket.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/5/1 20:09
 * Description:
 */
@Configuration
@Slf4j
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        log.error("index ---> before");
        registry.addViewController("/index").setViewName("index");
        log.error("index ---> after");
    }
}
