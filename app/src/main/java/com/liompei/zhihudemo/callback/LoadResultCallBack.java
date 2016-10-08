package com.liompei.zhihudemo.callback;

/**
 * Created by Liompei
 * on 2016/10/8.
 */

public interface LoadResultCallBack {
    int SUCCESS_OK = 1001;
    int SUCCESS_NONE = 1002;
    int ERROR_NET = 1003;

    void onSuccess(int result, Object object);

    void onError(int code, String msg);
}
