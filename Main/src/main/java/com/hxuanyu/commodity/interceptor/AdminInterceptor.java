package com.hxuanyu.commodity.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.utils.Constant;
import com.hxuanyu.commodity.utils.MsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 用户权限验证拦截器
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("拦截到请求：" + request.getRequestURI() + "  请求方式：" + request.getMethod());
        HttpSession session = request.getSession();
        if (request.getHeader(Constant.AJAX_HTTP_HEADER_KEY) != null && Constant.AJAX_HTTP_HEADER_VALUE.equalsIgnoreCase(request.getHeader(Constant.AJAX_HTTP_HEADER_KEY))) {
            logger.debug("检测到ajax请求");
            if (session != null) {
                Clerk clerk = (Clerk) session.getAttribute(Constant.SESSION_CLERK);
                if (1 != clerk.getAdmin()) {
                    logger.debug("权限不足，返回错误信息");
                    response.addHeader("Content-Type", "application/json;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.print(objectMapper.writeValueAsString(MsgUtil.errorMsg("您没有权限执行该操作")));
                    out.flush();
                    return false;
                }
            }
        } else {
            logger.debug("检测到普通请求");
            //非ajax请求时，session失效的处理
            if (session != null) {
                Clerk clerk = (Clerk) session.getAttribute(Constant.SESSION_CLERK);
                if (1 != clerk.getAdmin()) {
                    logger.debug("权限不足，重定向到首页");
                    response.sendRedirect(request.getContextPath() + "/");
                    return false;
                }
            }
        }
        logger.debug("请求验证通过");
        return true;
    }
}
