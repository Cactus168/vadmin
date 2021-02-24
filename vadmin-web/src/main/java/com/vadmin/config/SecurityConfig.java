package com.vadmin.config;

import com.vadmin.security.filter.JwtTokenFilter;
import com.vadmin.security.filter.LoginFilter;
import com.vadmin.security.handler.UnauthorizedHandler;
import com.vadmin.security.handler.LoginFailureHandler;
import com.vadmin.security.handler.LoginSuccessHandler;
import com.vadmin.security.handler.LogoutHandler;
import com.vadmin.service.RedisService;
import com.vadmin.service.login.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
/**
 * Spring Security配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 自定义用户登录认证逻辑
     */
    @Resource
    private LoginService loginService;

    /**
     * redis 缓存
     */
    @Resource
    private RedisService redisService;

    /**
     * 退出处理类
     */
    @Resource
    private LogoutHandler logoutHandler;

    /**
     * jwttoken认证过滤器
     */
    @Resource
    private JwtTokenFilter jwtTokenFilter;

    /**
     * 认证失败处理类
     */
    @Resource
    private UnauthorizedHandler unauthorizedHandler;

    /**
     * 登录成功处理类
     */
    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    /**
     * 登陆失败处理类
     */
    @Resource
    private LoginFailureHandler loginFailureHandler;

    /**
     * 密码加密编码配置
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置不需要认证的请求
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/verifyCode")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }

    /**
     * 请求授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // CRSF禁用，因为不使用session
            .csrf().disable()
            // 认证失败处理类
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            // 基于token，所以不需要session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            // 过滤请求
            .authorizeRequests()
            // 添加忽略拦截OPTIONS 类型的请求
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            //请求全部需要鉴权认证
            .anyRequest().authenticated()
            .and()
            .headers().frameOptions().disable();
        //退出系统处理
        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutHandler);
        //添加登陆验证 filter
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加JWT filter
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 登陆过滤
     * @return
     * @throws Exception
     */
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setRedisService(redisService);
        // 登录成功处理
        loginFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        // 登录失败处理
        loginFilter.setAuthenticationFailureHandler(loginFailureHandler);
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        return loginFilter;
    }

    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService);
    }

}
