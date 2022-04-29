package com.order_manage.myutils;

public class RestResponse {

    private final static String SUCCESS = "success";

    private final static String FAIL = "fail";

    public static <T> RestResult<T> makeOKRsp() {
        return new RestResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RestResult<T> makeOKRsp(String message) {
        return new RestResult<T>().setCode(ResultCode.SUCCESS).setMsg(message);
    }

    public static <T> RestResult<T> makeOKRsp(T data) {
        return new RestResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RestResult<T> makeErrRsp(String message) {
        return new RestResult<T>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMsg(message);
    }

    public static <T> RestResult<T> makeRsp(int code, String msg) {
        return new RestResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RestResult<T> makeRsp(int code, String msg, T data) {
        return new RestResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
