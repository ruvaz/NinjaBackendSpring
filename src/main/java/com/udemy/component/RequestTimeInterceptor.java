package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { //se ejecuta antes de entrar en el metodo del controlador

        request.setAttribute("startTome",System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {//se ejecutara despues de la ejecuciondel controlador

        //super.afterCompletion(request, response, handler, ex);
        long startTime = (long) request.getAttribute("startTime");

        LOG.info("------ REQUEST URL : '"+request.getRequestURL().toString()+"' ----- TOTAL TIME: '"+ (System.currentTimeMillis() - startTime)+"' ms.");
    }
}
