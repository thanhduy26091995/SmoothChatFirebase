package com.duybui.smoothchatfirebase.data.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by buivu on 01/12/2017.
 */

public class BaseResponseObject<T> {
    @SerializedName("success")
    protected boolean success;
    @SerializedName("message")
    protected String message;
    @SerializedName("errorCode")
    protected int errorCode;
    @SerializedName("data")
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public T getData() {
        return data;
    }
}
