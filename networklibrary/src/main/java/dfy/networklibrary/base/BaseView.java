package dfy.networklibrary.base;

import android.os.Bundle;

/**
 * Created by Admin on 2017/8/30.
 */

public interface BaseView {

    int setContentView();

    void initView(Bundle savedInstanceState);

    void initData();

    void setListener();

    void toastLong(String msg);

    void toastShort(String msg);

    void netRequestOk();

    void netRequestFail();
}
