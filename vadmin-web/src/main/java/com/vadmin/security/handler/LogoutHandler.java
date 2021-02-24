package com.vadmin.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadmin.common.utils.StringUtils;
import com.vadmin.model.LoginUser;
import com.vadmin.model.Rs;
import com.vadmin.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 退出系统成功，处理类
 */
@Component
public class LogoutHandler implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)){
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
        }
        out.write(new ObjectMapper().writeValueAsString(Rs.success("注销成功!")));
        out.flush();
        out.close();
    }
}
