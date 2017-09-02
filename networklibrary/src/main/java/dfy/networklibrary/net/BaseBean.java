package dfy.networklibrary.net;

/**
 * Created by Admin on 2017/8/30.
 */

public class BaseBean<T>{

    private int code;
    private String msg;


    public int getCode() {
        return code;
    }

    public BaseBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
