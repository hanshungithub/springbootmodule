package cn.hassan.interceptor.config;

import cn.hassan.interceptor.Interceptor.SessionInteceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/23 22:56
 * Description:
 */
@Configuration
public class SessionConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInteceptor()).addPathPatterns("/**");
    }
}
