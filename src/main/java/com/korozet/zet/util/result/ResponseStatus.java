package com.korozet.zet.util.result;

public enum ResponseStatus {
    OK(0,"操作成功"),
    BAD_REQUEST(401,"请求无效"),
    ERR(1,"数据处理失败"),
    INTERNAL_SERVER_ERROR(500,"服务异常");



    private int code;
    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
