package cn.codewoo.exception;

import cn.codewoo.utils.IBaseRespCode;

/**
 * @author kehong
 * 自定义异常
 */
public class BusinessException extends RuntimeException {
    private int code;
    private String msg;

    public BusinessException() {
        super();
    }

    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(IBaseRespCode code){
        this(code.getCode(), code.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
