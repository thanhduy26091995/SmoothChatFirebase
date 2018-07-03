package com.duybui.smoothchatfirebase.data.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by buivu on 01/12/2017.
 */

public class BaseResponseList<T> extends BaseResponseObject {
    @SerializedName("data")
    private List<T> listData;

    public List<T> getListData() {
        return listData;
    }
}
