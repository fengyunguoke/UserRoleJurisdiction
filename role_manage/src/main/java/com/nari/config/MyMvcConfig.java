package com.nari.config;

import com.nari.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//代表这是一个配置类，
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //通过配置类来设置视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/Admin.html").setViewName("dashboard101");
        registry.addViewController("/generalAdmin.html").setViewName("dashboard102");
        registry.addViewController("/User.html").setViewName("dashboard103");
    }

    //自定义的国际化组件就生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //选择要过滤和排除的请求
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/user/login","/roleList","/Admin.html", "/generalAdmin.html", "/User.html")
                .excludePathPatterns("/static/asserts/**");
    }
}
