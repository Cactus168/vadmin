package com.vadmin.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vadmin.common.constant.Constants;
import com.vadmin.service.RedisService;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆校验验证码
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisService redisService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("身份验证方法必须为POST请求");
        }
        if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            Map<String, String> loginData = new HashMap<>();
            try {
                loginData = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            } catch (IOException e) {
            } finally {
                String uuid = loginData.get("uuid");
                String code = loginData.get("code");
                String verifyCode = this.redisService.getCacheObject(Constants.CAPTCHA_CODE_KEY+uuid);
                System.out.println(uuid+"--------->"+verifyCode);
                checkCode(code, verifyCode);
            }
            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username.trim(), password);
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }else{
            String uuid = request.getParameter("uuid");
            String verifyCode = this.redisService.getCacheObject(Constants.CAPTCHA_CODE_KEY+uuid);
            checkCode(request.getParameter("code"), verifyCode);
            return super.attemptAuthentication(request, response);
        }
    }

    public void checkCode(String code, String verifyCode) {
        if (code == null || verifyCode == null || "".equals(code) || !verifyCode.toLowerCase().equals(code.toLowerCase())) {
            //验证码不正确
            throw new AuthenticationServiceException("验证码不正确");
        }
    }

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }
}
