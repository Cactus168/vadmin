package com.vadmin.model.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vadmin.model.BaseModel;

import java.util.Date;

/**
 * OperLog
 * @auther: Grug
 * @date: 2020/8/19 16:20
 */
public class OperLog extends BaseModel{

    private Long operId;

    /** 操作模块 */
    private String moduleName;

    /** 操作类型 如：新增 、修改 、删除 */
    private String operateType;

    /** 请求方法 */
    private String method;

    /** 请求方式 */
    private String requestMethod;

    /** 操作系统 如：其它、后台用户、手机端用户） */
    private String operOs;

    /** 操作人员 */
    private String operName;

    /** 请求url */
    private String operUrl;

    /** 操作地址 */
    private String operIp;

    /** 操作地点 */
    private String operLocation;

    /** 请求参数 */
    private String operParam;

    /** 返回参数 */
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    private String status;

    /** 错误消息 */
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operTime;

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getOperOs() {
        return operOs;
    }

    public void setOperOs(String operOs) {
        this.operOs = operOs;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        return "OperLog{" +
                "operId=" + operId +
                ", moduleName='" + moduleName + '\'' +
                ", operateType='" + operateType + '\'' +
                ", method='" + method + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", operOs='" + operOs + '\'' +
                ", operName='" + operName + '\'' +
                ", operUrl='" + operUrl + '\'' +
                ", operIp='" + operIp + '\'' +
                ", operLocation='" + operLocation + '\'' +
                ", operParam='" + operParam + '\'' +
                ", jsonResult='" + jsonResult + '\'' +
                ", status='" + status + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", operTime=" + operTime +
                '}';
    }
}
