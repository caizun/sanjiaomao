package xyz.sanjiaomao.infrastructure.auth;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-18 21:59
 */
@SpringBootConfiguration
public class AuthConfiguration {


  @Bean
  public FilterRegistrationBean<AuthFilter> authFilter(){
    FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(new AuthFilter());
    filterFilterRegistrationBean.addUrlPatterns("/*");
    filterFilterRegistrationBean.setName("authFilter");
    filterFilterRegistrationBean.setOrder(1);
    return filterFilterRegistrationBean;
  }


}
