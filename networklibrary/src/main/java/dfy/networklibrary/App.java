package dfy.networklibrary;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.logging.Level;

import dfy.networklibrary.net.ActivityManager;
import okhttp3.OkHttpClient;

/**
 * Created by Admin on 2017/8/30.
 */

public class App extends Application {


    private static ActivityManager activityManager = null; // activity管理类
    @Override
    public void onCreate() {
        super.onCreate();
        activityManager = ActivityManager.getInstance(); // 获得实例
        initTools();
        initOkGo();
    }

    private void initOkGo(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.NONE);
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);

        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build());

    }
    private void initTools(){
        Utils.init(this);
    }


    public static ActivityManager getActivityManager() {
        return activityManager;
    }

}

