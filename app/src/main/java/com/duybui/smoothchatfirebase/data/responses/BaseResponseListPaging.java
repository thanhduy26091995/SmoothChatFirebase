package com.duybui.smoothchatfirebase.data.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by buivu on 01/12/2017.
 */

public class BaseResponseListPaging<T> extends BaseResponseObject {
    @SerializedName("data")
    private List<T> listData;
    @SerializedName("totalPage")
    private Integer totalPage;
    @SerializedName("itemperPage")
    private Integer itemPerPage;
    @SerializedName("nextPage")
    private String nextPage;
    @SerializedName("previousPage")
    private String previousPage;
    @SerializedName("currentPage")
    private Integer currentPage;

    public List<T> getListData() {
        return listData;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getItemPerPage() {
        return itemPerPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public String getPreviousPage() {
        return previousPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }
}
