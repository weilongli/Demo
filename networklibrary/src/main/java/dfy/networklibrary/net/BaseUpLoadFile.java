package dfy.networklibrary.net;

import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

import java.io.File;
import java.util.List;

import dfy.networklibrary.App;
import dfy.networklibrary.loadingdialog.view.LoadingDialog;

/**
 * Created by Admin on 2017/8/31.
 */

public class BaseUpLoadFile<T extends BaseFileBean> {
    private UpLoadFile mUpLoadFile;
    //上传文件的文件集合
    private List<File> httpfile;
    private String fileKey;

    //设置是否需要加载进行中进度
    private boolean isLoading = false;
    private boolean isJsonException = true;
    private Gson mGson;
    //请求url
    private String URL;


    //加载弹出框
    private LoadingDialog mLoadingDialog;
    LoadingDialog.Speed speed = LoadingDialog.Speed.SPEED_TWO;
    private boolean intercept_back_event = false;
    private int repeatTime = 0;

    //json解析数据类型
    private Class<T> clazz;


    private boolean isMultPart = false;

    public BaseUpLoadFile(){
        mGson = new Gson();
        mLoadingDialog = new LoadingDialog(App.getActivityManager().currentActivity());
    }
    /**
     * 设置是否以表单上传
     * @param isMultiPart
     * @return
     */
    public BaseUpLoadFile setIsMultiPart(boolean isMultiPart) {
        this.isMultPart = isMultiPart;
        return this;
    }

    /**
     * 设置地址
     *
     * @param url
     * @return
     */
    public BaseUpLoadFile setURL(String url) {
        this.URL = url;
        return this;
    }

    /**
     * 设置加载静读条
     *
     * @param isLoading
     * @return
     */
    public BaseUpLoadFile setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
        return this;
    }

    public BaseUpLoadFile UpLoadFile(UpLoadFile upLoadFile){
        this.mUpLoadFile=upLoadFile;
        return this;
    }
    /**
     * 上传文件的key,以及文件集合
     * @param fileKey
     * @param files
     * @return
     */
    public BaseUpLoadFile setUpLoadFile(String fileKey, List<File> files) {
        this.fileKey = fileKey;
        this.httpfile = files;
        return this;
    }


    /**
     * 上传文件
     */
    public void upLoadFile() {

        if (!NetworkUtils.isConnected()) {
            mLoadingDialog
                    .setInterceptBack(intercept_back_event)
                    .setLoadSpeed(speed)
                    .closeSuccessAnim()
                    .setRepeatCount(repeatTime)
                    .show();
            mLoadingDialog.loadNetFailed();
            return;
        }
        printURL();
        OkGo.<String>post(URL)
                .tag(this)
                .addFileParams(fileKey, httpfile)
                .execute(new StringCallback() {

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (isLoading) {
                            mLoadingDialog
                                    .setInterceptBack(intercept_back_event)
                                    .setLoadSpeed(speed)
                                    .closeSuccessAnim()
                                    .setRepeatCount(repeatTime)
                                    .show();
                            mLoadingDialog.loadupLoadFailed();
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        if (mGson == null) mGson = new Gson();
                        T dataType = null;
                        try {
                            dataType = mGson.fromJson(response.body(), clazz);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(ConstantNet.JSONEXCEPTION, e.getMessage());
                        } finally {
                            printJson(response.body());
                        }
                        //解析成功
                        if (dataType != null) {
                            //返回上传成功后的数据
                            mUpLoadFile.upLoadFileSuccess(dataType);
                        } else {//解析失败
                            if (isJsonException) {
                                if (mLoadingDialog != null) {
                                    mLoadingDialog
                                            .setSuccessText("数据解析失败!")
                                            .setInterceptBack(intercept_back_event)
                                            .setLoadSpeed(speed)
                                            .closeSuccessAnim()
                                            .setRepeatCount(repeatTime)
                                            .show();
                                    mLoadingDialog.loadJsonFailed();
                                }
                            }
                        }
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);
                        //上传文件的进度
                        if (mUpLoadFile != null) {
                            mUpLoadFile.upLoadProgress(progress);
                        }
                    }
                });
    }

    /**
     * 打印URL
     */
    private void printURL() {
        Log.i(ConstantNet.LOG_URL,URL);
    }

    /**
     * 打印输出内容
     * @param json
     */
    private void printJson(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            Log.i(ConstantNet.LOG_JSON, jsonObject.toString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface UpLoadFile<T extends BaseFileBean> {

        /**
         * 上传文件
         *
         * @param t
         */
        void upLoadFileSuccess(T t);

        /**
         * 上传文件进度
         *
         * @param preogress
         */
        void upLoadProgress(Progress preogress);
    }
}
