package com.vadmin.exception;

import com.vadmin.common.constant.HttpStatus;
import com.vadmin.common.exception.BaseException;
import com.vadmin.common.exception.CustomException;
import com.vadmin.common.utils.StringUtils;
import com.vadmin.model.Rs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public Rs baseException(BaseException e) {
        return Rs.error(e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(CustomException.class)
    public Rs businessException(CustomException e){
        if (StringUtils.isNull(e.getCode())) {
            return Rs.error(e.getMessage());
        }
        return Rs.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Rs handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return Rs.error(HttpStatus.NOT_FOUND, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Rs handleAuthorizationException(AccessDeniedException e){
        log.error(e.getMessage());
        return Rs.error(HttpStatus.FORBIDDEN, "没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public Rs handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Rs.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public Rs validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return Rs.error(message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return Rs.error(message);
    }
}
