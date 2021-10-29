package com.hbxy.ssm.login.interceptor;

import com.hbxy.ssm.admin.user.model.UserLogin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

public class LoginInterceptor implements HandlerInterceptor {
    //不拦截的url:有些url不需要进行拦截
    public static final HashSet<String> IGNORE_URI = new HashSet<String>() {{
        add("/login");
        add("/noright");
        add("/sba");
        add("/error");
    }};

    // 该方法将在 Controller 处理前进行调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // flag 表示是否登录
        boolean flag = false;
        // 获取请求的 URL
        String url = request.getServletPath();

        //1 首先判断进来的url是否在忽略的列表里
        // 如果在,则不需要登录,允许通过
        if(IGNORE_URI.contains(url)) {
            flag = true;
        }else{
            // 2 开始进行认证
            // 身份认证: 通过获取 Session 并判断是否已经登录
            UserLogin userLogin =
                    (UserLogin)request.getSession().getAttribute("USER_SESSION");
            if (userLogin != null) {
                flag = true;
            } else {
                // 如果未登录，直接跳转到登录页面
                response.sendRedirect(request.getContextPath()+"/login");
            }
        }
        //3 最后通过判断flag,是否允许通过拦截器:true-允许;false-不允许
        return flag;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
