package com.vadmin.aspectj;
import java.lang.reflect.Method;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vadmin.common.annotation.Log;
import com.vadmin.common.constant.UserConstants;
import com.vadmin.common.utils.HttpContextUtils;
import com.vadmin.common.utils.StringUtils;
import com.vadmin.model.LoginUser;
import com.vadmin.model.sys.OperLog;
import com.vadmin.security.SecurityUtils;
import com.vadmin.service.sys.OperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;

/**
 * 操作日志记录处理
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Resource
    public OperLogService operLogService;

    // 配置织入点
    @Pointcut("@annotation(com.vadmin.common.annotation.Log)")
    public void logPointCut(){}

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     * 
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }

    /**
     * 处理日志
     * @author Grug
     * @date  2020/8/19 17:54
     * @param joinPoint
     * @param e
     * @param jsonResult
     * @return void
     */
    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {
            // 获得注解
            Log logClazz = getClassLog(joinPoint);
            Log logMethod = getMethodLog(joinPoint);
            if(logClazz == null){
                return;
            }
            if(logMethod == null){
                return;
            }
            // 获取当前的用户
            LoginUser loginUser = SecurityUtils.getLoginUser();
            HttpServletRequest request = HttpContextUtils.getRequest();

            // *========数据库日志=========*//
            OperLog operLog = new OperLog();
            // 请求的状态
            operLog.setStatus(UserConstants.NORMAL);
            // 请求的ip
            operLog.setOperIp(loginUser.getIpaddr());
            // 返回参数
            operLog.setJsonResult(JSON.toJSONString(jsonResult));
            // 操作url
            operLog.setOperUrl(request.getRequestURI());
            // 操作用户
            operLog.setOperName(loginUser.getUser().getRealName());
            // 操作地点
            operLog.setOperLocation(loginUser.getLoginLocation());
            if (e != null){
                operLog.setStatus(UserConstants.EXCEPTION);
                operLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            operLog.setRequestMethod(request.getMethod());
            // 处理设置注解上的参数
            // 设置action动作
            operLog.setOperateType(logMethod.operateType());
            // 设置标题
            operLog.setModuleName(logClazz.moduleName());
            // 设置操作人类别
            operLog.setOperOs(loginUser.getOs());
            //请求的参数
            String params = argsArrayToString(joinPoint.getArgs());
            operLog.setOperParam(StringUtils.substring(params, 0, 2000));
            // 保存数据库
            log.debug(operLog.toString());
            this.operLogService.add(operLog);
        }catch (Exception exp){
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getClassLog(JoinPoint joinPoint) throws Exception {
        Class<?> clazz = joinPoint.getTarget().getClass();
        if (clazz != null){
            return clazz.getAnnotation(Log.class);
        }
        return null;
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getMethodLog(JoinPoint joinPoint) throws Exception {
        if(getClassLog(joinPoint) != null){
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();;
            Method method = methodSignature.getMethod();
            if (method != null){
                return method.getAnnotation(Log.class);
            }
        }
        return null;
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (int i = 0; i < paramsArray.length; i++) {
                if (!isFilterObject(paramsArray[i])) {
                    Object jsonObj = JSON.toJSON(paramsArray[i]);
                    params += jsonObj.toString() + " ";
                }
            }
        }
        return params.trim();
    }

    /**
     * 判断是否需要过滤的对象。
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    public boolean isFilterObject(final Object o) {
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
    }
}
