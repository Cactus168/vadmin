package com.vadmin.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadmin.common.constant.HttpStatus;
import com.vadmin.model.Rs;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证失败处理类 返回未授权
 */
@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Rs rs = Rs.error(HttpStatus.UNAUTHORIZED,"认证失败，无法访问系统资源");
        out.write(new ObjectMapper().writeValueAsString(rs));
        out.flush();
        out.close();
    }
}
