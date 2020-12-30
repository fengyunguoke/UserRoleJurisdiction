package com.nari.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登陆拦截器，实现处理器拦截器接口
public class LoginInterceptor implements HandlerInterceptor {

    /*
    * preHandle 预处理回调方法实现处理器的预处理，第三个参数为相应的处理器，返回 true 则表示继续流程，
    * 如调用下一个处理器，返回 false 表示流程中断，此时需要调用 response 来产生响应
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("loginUser")==null){
            request.setAttribute("msg","没有权限,请先登录!");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            return true;                    //处理器拦截器
        }
    }
}
