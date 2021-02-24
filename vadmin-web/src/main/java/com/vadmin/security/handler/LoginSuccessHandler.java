package com.vadmin.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadmin.model.LoginUser;
import com.vadmin.model.Rs;
import com.vadmin.model.sys.LoginLog;
import com.vadmin.service.TokenService;
import com.vadmin.service.sys.LoginLogService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登陆成功，处理类
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    public TokenService tokenService;

    @Resource
    public LoginLogService loginLogService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        tokenService.createToken(request,loginUser);
        loginLogService.add(new LoginLog(loginUser));
        out.write(new ObjectMapper().writeValueAsString(Rs.success("登录成功!", loginUser)));
        out.flush();
        out.close();
    }
}
