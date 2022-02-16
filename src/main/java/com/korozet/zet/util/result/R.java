package com.korozet.zet.util.result;



public class R {

    private Integer code;
    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private String msg;
    private Object data;

    public R(){}

    public R(int code, String msg) {
        this.setCode(code);
        this.setMessage(msg);
    }

    public R(ResponseStatus carStatus) {
        this.setCode(carStatus.getCode());
        this.setMessage(carStatus.getMsg());
    }

    public R(int code, String msg, Object data) {
        this.setCode(code);
        this.setMessage(msg);
        this.setData(data);
    }

    public R(ResponseStatus carStatus, Object data) {
        this.setCode(carStatus.getCode());
        this.setMessage(carStatus.getMsg());
        this.setData(data);
    }

    public static R of(int code, String msg){
        return new R(code,msg);
    }
    public static R of(ResponseStatus status){
        return new R(status);
    }

    public static R of(int  status,  String msg, Object data){
        return new R(status,msg, data);
    }
    public static R of(ResponseStatus carStatus, Object data){
        return new R(carStatus, data);
    }

    public static R ok(){
        return R.of(ResponseStatus.OK);
    }
    public static R ok(Object data){
        return R.of(ResponseStatus.OK, data);
    }
    public static R ok(Integer code,String msg,Object data){
        return R.of(code,msg,data);
    }
    public static R error(){
        return R.of(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
    public static R error(String msg){
        return R.of(ResponseStatus.INTERNAL_SERVER_ERROR.getCode(),msg);
    }
    public static R badRequest(){
        return R.of(ResponseStatus.BAD_REQUEST);
    }
    public static R badRequest(String msg){
        return R.of(ResponseStatus.BAD_REQUEST.getCode(),msg);
    }
    public static R err(){
        return R.of(ResponseStatus.OK);
    }

    public static R err(String msg){
        return R.of(ResponseStatus.ERR,msg);
    }
}
