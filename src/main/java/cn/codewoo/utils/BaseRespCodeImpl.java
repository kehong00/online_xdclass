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
    ERROR(-1,"操作失败")
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
