package cn.codewoo.utils;

/**
 * @author kehong
 * 存放自定义响应码的枚举
 */

public enum BaseRespCodeImpl implements IBaseRespCode {
    /**
     * 默认成功
     */
    SUCCESS(0,"操作成功"),
    /**
     * 默认失败
     */
    ERROR(-1,"操作失败"),
    /**
     * 系统异常响应码
     */
    SYS_ERROR(50000,"系统错误"),
    USER_REG_ERROR(50001,"注册失败"),
    USER_LOGIN_NOT_FOUNT(40004,"用户不存在"),
    USER_LOGIN_PWD_ERROR(40005,"用户名或密码错误"),
    NOT_LOGIN(40006,"没有登录，请登录"),
    LOGIN_EXPIRE(40007,"用户凭证已过期，请重新登录"),
    AUTHENTICATED_ERROR(40008,"认证失败，请重试"),
    ;

    /**
     * 响应码
     */
    private int code;
    /**
     * 响应消息
     */
    private String msg;

    BaseRespCodeImpl(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
