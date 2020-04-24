package com.electronic.base;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable{
    private static final long serialVersionUID = 5962894491806765550L;

    private boolean success;
    /**
     * 是否成功代码："000000":成功，其他失败
     */
    private String resultCode;

    /**
     * 是否成功代码对应的信息
     */
    private String resultMessage;
    /**
     * 用于异常时，存放堆栈信息
     */
    private Object info="";

    /**
     * 业务数据
     */
    private T result=null;

    public BaseResponse() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public BaseResponse(String resultCode, String resultMessage, Object info, T result) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.info = info;
        this.result = result;
    }


    public BaseResponse(boolean success, String resultCode, String resultMessage, Object info, T result) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.info = info;
        this.result = result;
    }

    public BaseResponse(boolean success, String resultCode, String resultMessage) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
}
