package com.pochita.actccommon.exception;

import com.pochita.actccommon.enums.BizCodeEnum;
import lombok.Data;

/**
 * @author: Junko
 * @date: 2025/12/22 23:19
 * @Version: 1.0
 * @description:
 */
@Data
public class BizException extends RuntimeException {

    private int code;
    private String msg;
    private String detail;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BizException(BizCodeEnum bizCodeEnum){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }

    public BizException(BizCodeEnum bizCodeEnum,Exception e){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
        this.detail = e.toString();
    }

}
