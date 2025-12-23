package com.pochita.actccommon.exception;

import com.pochita.actccommon.util.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Junko
 * @date: 2025/12/22 23:24
 * @Version: 1.0
 * @description:
 */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public static JsonData handler(Exception e) {
        if (e instanceof BizException bizException) {
            log.error("[业务异常]{}",e);
            return JsonData.buildCodeAndMsg(bizException.getCode(),bizException.getMsg());
        } else {
            log.error("[系统异常]{}",e);
            return JsonData.buildError("系统异常");
        }
    }
}
