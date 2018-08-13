package com.hand.infra.handler;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 出错处理Handler
public class MyWebHandlerException implements HandlerExceptionResolver {
    private static Logger logger = Logger.getLogger(MyWebHandlerException.class);

    /**
     * 值得注意的是我们实现HandlerExceptionResolver接口或者使用@ExceptionHandler注解这种两种方式只能处理Controller层之内的异常，
     * 对于渲染层及其他的异常是无能为力的，如果我们要做全局的异常处理就需要结合容器来做处理了。
     * 注意，当返回值指定视图时会自动跳转至指定的视图中去，如果返回null，会继续调用下一个异常处理器去执行。
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("[error]出错了，请查看日志");
        logger.info("出错消息：" + e.getMessage() + "出错原因：" + e.getStackTrace().toString());
        e.printStackTrace();

        if (e instanceof RuntimeException) {     // 根据不同的异常类型来返回不同的页面
            return new ModelAndView("runtime-exception");
        }
        return new ModelAndView("exception");
    }
}
