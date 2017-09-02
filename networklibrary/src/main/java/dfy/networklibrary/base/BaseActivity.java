package dfy.networklibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dfy.networklibrary.App;

/**
 * Created by Admin on 2017/9/1.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    public Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
//        App.getActivityManager().pushActivity(this);
        mContext=this;
        initView(savedInstanceState);
        initData();
        setListener();

    }

    /**
     * 获取布局id;
     * @return
     */
    public abstract int setContentView();

    /**
     * 初始化View
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 设置监听
     */
    public void setListener(){

    }

    /**
     * 设置Toast,类型Long
     * @param msg
     */
    @Override
    public void toastLong(String msg) {

    }

    /**
     * 设置Toast，类型Short
     * @param msg
     */
    @Override
    public void toastShort(String msg) {

    }

    /**
     * 网络请求成功
     */
    @Override
    public void netRequestOk() {

    }

    /**
     * 请求失败
     */
    @Override
    public void netRequestFail() {

    }
}
