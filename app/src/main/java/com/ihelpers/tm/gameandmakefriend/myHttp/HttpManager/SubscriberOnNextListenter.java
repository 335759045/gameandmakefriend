package com.ihelpers.tm.gameandmakefriend.myHttp.HttpManager;

/**
 * Created by Administrator on 2017/12/19.
 */

public interface SubscriberOnNextListenter<T> {
    void next(T t);
    void getErr(int i);
}
