package com.hand.infra.config;

import com.hand.infra.handler.MyWebHandlerException;
import com.hand.infra.interceptor.FilmHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// 配置拦截器类,WebMvcConfigurerAdapter类在Spring高版本被废弃，建议直接使用WebMvcConfigurer接口
@Configuration
public class MyWebAopConfig implements WebMvcConfigurer {
    /**
     * 注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器实现类，添加触发拦截器的URL参数
        // SpringMVC会根据声明的前后顺序一个接一个的执行，这里有两个拦截器作对比
        registry.addInterceptor(new FilmHandlerInterceptor()).addPathPatterns("/listFilm*");
    }

    /**
     * 扩展 处理程序异常解析器
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        // 添加异常捕捉实现类
        // 如果发生异常SpringMVC会根据声明的前后顺序进行顺序捕捉，一旦被某一个捕捉了则后续异常处理失效类似try-catch多个catch
        // 我们也可以通过下面注释了的方法直接指定过滤器的顺序，从小到大顺序执行类似过滤器的@Order
        // resolvers.add(0, new MyWebExceptionHandler());
        resolvers.add(new MyWebHandlerException());
    }
}
