package com.iboxpay.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.iboxpay.web.interceptors.StudentInterceptor;

@Configuration
@EnableSpringDataWebSupport
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //增加资源处理器，资源处理器在每个匹配指定url的请求到来时都会被调用，增加资源的位置，用于放置js文件，映射地址为localhost:8080/js/
        //可以添加多个resourcesLocations，先添加的优先级高于后添加的，访问目录为为src/main/resources/js/
        //注意：下面注册的是一组资源处理器和资源位置，只能同时使用
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");
    }

    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        //使用FastJsonHttpMessageConverter作为消息转换器，用以覆盖默认的Jackson2消息转换器
        FastJsonHttpMessageConverter fastJsonConverter =
                new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        Charset utf8 = Charset.forName("UTF-8");
        supportedMediaTypes.add(new MediaType("text", "html", utf8));
        supportedMediaTypes.add(new MediaType("application", "json", utf8));
        supportedMediaTypes.add(new MediaType("application", "*+json", utf8));
        fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(fastJsonConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StudentInterceptor())
                .addPathPatterns("/student/findAllStudent.json");
    }
}
