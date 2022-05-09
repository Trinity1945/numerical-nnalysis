package com.zhang.mathanalyze.common;

public enum ErrorCode {
    SUCCESS(0,"ok",""),
    PARAMS_ERROR(250, "请求参数错误", ""),
    NULL_ERROR(290, "数据为空", ""),
    SYSTEM_ERROR(500,"系统内部异常","");

    private final int code;
    /**
     * 状态吗信息
     */
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 状态描述（详情）
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
}
