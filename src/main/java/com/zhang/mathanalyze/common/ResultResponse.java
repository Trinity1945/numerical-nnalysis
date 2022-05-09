package com.zhang.mathanalyze.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultResponse<T> implements Serializable {
    private int code;

    private T data;

    private String message;

    private String description;
    public ResultResponse(int code, T data,String message) {
        this(code,data,message,"");
    }

    public ResultResponse(int code, T data, String message,String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description=description;
    }

    public ResultResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null,errorCode.getDescription());
    }

}
