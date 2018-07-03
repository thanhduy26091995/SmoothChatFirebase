package com.duybui.smoothchatfirebase.data.networks.api;

import com.duybui.smoothchatfirebase.R;
import com.duybui.smoothchatfirebase.data.networks.main.ApiClient;
import com.duybui.smoothchatfirebase.data.networks.main.ApiInterfaces;
import com.duybui.smoothchatfirebase.data.responses.BaseResponseList;
import com.duybui.smoothchatfirebase.data.responses.BaseResponseListPaging;
import com.duybui.smoothchatfirebase.data.responses.BaseResponseObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by buivu on 20/09/2017.
 */

public class ApiMethod {
    private ApiListener mApiListener;

    public void setApiListener(ApiListener mApiListener) {
        this.mApiListener = mApiListener;
    }

    /*
    Danh sách các hàm gọi api
     */
    public void test() {
        ApiInterfaces apiInterfaces = ApiClient.getClient().create(ApiInterfaces.class);
        handleResponseObject(apiInterfaces.getHome(), ApiFunction.GET_HOME);
    }

    /*
    Kết thúc danh sách hàm
     */

    /*
    response trả về 1 object, thường áp dụng cho response khi login, signup...
     */
    private <T> void handleResponseObject(Call<BaseResponseObject<T>> responseCall, final ApiFunction apiFunction) {
        responseCall.enqueue(new Callback<BaseResponseObject<T>>() {
            @Override
            public void onResponse(Call<BaseResponseObject<T>> call, Response<BaseResponseObject<T>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_SUCCESS, response.body());
                    } else {
                        notifyErrorFromServer(apiFunction, ApiStatus.CALL_API_RESULT_FAILURE, response.body().getErrorCode());
                    }
                } else {
                    notifyErrorFromServer(apiFunction, ApiStatus.CALL_API_RESULT_FAILURE, response.body().getErrorCode());
                }
            }

            @Override
            public void onFailure(Call<BaseResponseObject<T>> call, Throwable t) {
                mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_TIMEOUT, t.getMessage());
            }
        });
    }
    /*
    response trả về là 1 danh sách, thường áp dụng cho response khi lấy danh sách (không phân trang)
     */

    private <T> void handleResponseList(Call<BaseResponseList<T>> responseListCall, final ApiFunction apiFunction) {
        responseListCall.enqueue(new Callback<BaseResponseList<T>>() {
            @Override
            public void onResponse(Call<BaseResponseList<T>> call, Response<BaseResponseList<T>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_SUCCESS, response.body());
                    } else {
                        notifyErrorFromServer(apiFunction, ApiStatus.CALL_API_RESULT_FAILURE, response.body().getErrorCode());
                    }
                } else {
                    notifyErrorFromServer(apiFunction, ApiStatus.CALL_API_RESULT_FAILURE, response.body().getErrorCode());
                }
            }

            @Override
            public void onFailure(Call<BaseResponseList<T>> call, Throwable t) {
                mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_TIMEOUT, t.getMessage());
            }
        });
    }

    /*
    response trả về là 1 danh sách, thường áp dụng cho response khi lấy danh sách (có phân trang)
     */
    private <T> void handleResponseListPaging(Call<BaseResponseListPaging<T>> responseListPagingCall, final ApiFunction apiFunction) {
        responseListPagingCall.enqueue(new Callback<BaseResponseListPaging<T>>() {
            @Override
            public void onResponse(Call<BaseResponseListPaging<T>> call, Response<BaseResponseListPaging<T>> response) {
                if (response.isSuccessful()) {
                    if (response.body().isSuccess()) {
                        mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_SUCCESS, response.body());
                    } else {
                        notifyErrorFromServer(apiFunction, ApiStatus.CALL_API_RESULT_FAILURE, response.body().getErrorCode());
                    }
                } else {
                    notifyErrorFromServer(apiFunction, ApiStatus.CALL_API_RESULT_FAILURE, response.body().getErrorCode());
                }
            }

            @Override
            public void onFailure(Call<BaseResponseListPaging<T>> call, Throwable t) {
                mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_TIMEOUT, t.getMessage());
            }
        });
    }

    /*
    xử lý lỗi từ server trả về
     */
    private void notifyErrorFromServer(ApiFunction apiFunction, ApiStatus apiStatus, int errorCode) {
        switch (errorCode) {
            case 401:
                mApiListener.onResponseListener(apiFunction, apiStatus, R.string.error_401);
                break;
            default:
                mApiListener.onResponseListener(apiFunction, apiStatus, R.string.error_404);
        }
    }
}
