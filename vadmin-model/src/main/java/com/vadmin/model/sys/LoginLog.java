package com.vadmin.model.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vadmin.model.BaseModel;
import com.vadmin.model.LoginUser;

import java.util.Date;

/**
 * LoginLog
 *
 * @auther: Grug
 * @date: 2020/8/19 18:02
 */
public class LoginLog extends BaseModel {

    /** ID */
    private Long loginId;

    /** 用户账号 */
    private String userName;

    /** 登录IP地址 */
    private String ipaddr;

    /** 登录地点 */
    private String loginLocation;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String loginOs;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    public LoginLog() {
    }

    public LoginLog(LoginUser loginUser) {
        this.userName = loginUser.getUsername();
        this.ipaddr = loginUser.getIpaddr();
        this.loginLocation = loginUser.getLoginLocation();
        this.browser = loginUser.getBrowser();
        this.loginOs = loginUser.getOs();;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getLoginOs() {
        return loginOs;
    }

    public void setLoginOs(String loginOs) {
        this.loginOs = loginOs;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
