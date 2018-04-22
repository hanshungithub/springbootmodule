package cn.hassan.fastjson.configs;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class DruidConfig {

    @Value("${druid-loginName}")
    private String loginName;

    @Value("${druid-loginPwd}")
    private String loginPwd;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 设置druid后台登录servlet
     *
     * @return 注册的druid servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //注册druid servlet
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        log.error("注入的用户名 ---> " +loginName);
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", loginName);
        map.put("loginPassword", loginPwd);

        bean.setInitParameters(map);
        return bean;
    }

    /**
     * 配置web监控的filter
     *
     * @return 注册的druid filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
