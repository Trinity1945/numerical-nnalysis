package com.zhang.mathanalyze.common;

public class ResultUtils {
    public static <T> ResultResponse<T> success(T data){
        return new ResultResponse<>(0,data,"ok");
    }

    /**
     * 失败
     * @param errorCode 错误吗
     */
    public static ResultResponse error(ErrorCode errorCode){
        return new ResultResponse<>(errorCode);
    }

    /**
     * 失败
     */
    public static ResultResponse error(int code,String message,String description){
        return new ResultResponse<>(code,null,message,description);
    }

    /**
     * 失败
     */
    public static ResultResponse error(ErrorCode errorCode,String message,String description){
        return new ResultResponse<>(errorCode.getCode(),null,message,description);
    }

    /**
     * 失败
     */
    public static ResultResponse error(ErrorCode errorCode,String description){
        return new ResultResponse<>(errorCode.getCode(),null,description);
    }

}
