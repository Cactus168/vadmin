package com.vadmin.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadmin.model.Rs;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录失败，处理类
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Rs rs = Rs.error(exception.getMessage());
        if (exception instanceof LockedException) {
            rs.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            rs.setMsg("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            rs.setMsg("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            rs.setMsg("账户被禁用，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            rs.setMsg("用户名或者密码输入错误，请重新输入!");
        }
        out.write(new ObjectMapper().writeValueAsString(rs));
        out.flush();
        out.close();
    }
}
