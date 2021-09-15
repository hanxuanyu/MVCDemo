package com.hxuanyu.commodity.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxuanyu.commodity.utils.Constant;
import com.hxuanyu.commodity.utils.MsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录拦截器
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("拦截到请求：" + request.getRequestURI() + "  请求方式：" + request.getMethod());
        HttpSession session = request.getSession();
        //如果是ajax请求响应头会有x-requested-with
        if (request.getHeader(Constant.AJAX_HTTP_HEADER_KEY) != null && Constant.AJAX_HTTP_HEADER_VALUE.equalsIgnoreCase(request.getHeader(Constant.AJAX_HTTP_HEADER_KEY))) {
            logger.debug("检测到ajax请求");
            if (session != null && session.getAttribute(Constant.SESSION_KEY) == null) {
                logger.debug("未登录，返回错误信息");
                response.addHeader("Content-Type", "application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print(objectMapper.writeValueAsString(MsgUtil.errorMsg("session已过期，请重新登陆")));
                out.flush();
                return false;
            }
        } else {
            logger.debug("检测到普通请求");
            //非ajax请求时，session失效的处理
            if (session != null) {
                Object object = session.getAttribute(Constant.SESSION_KEY);
                if (object == null) {
                    logger.debug("未登录，重定向到登录页面");
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
                }
            }
        }
        logger.debug("请求验证通过");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor: postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor: afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
