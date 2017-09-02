package dfy.networklibrary.base;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import dfy.networklibrary.App;

/**
 * Created by Admin on 2017/9/1.
 */

public class BasePopuWindow extends PopupWindow{

    private PopupWindow mPopupWindow;

    private boolean isHide=true;
    public BasePopuWindow setClickFocusable(boolean isHide){
        this.isHide=isHide;
        return this;
    }

    public BasePopuWindow getInstanceWindow(View mContentView){
        mPopupWindow=new PopupWindow(mContentView);

        mPopupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp =  App.getActivityManager().currentActivity().getWindow().getAttributes();
                lp.alpha = 1.0f; //0.0-1.0
                App.getActivityManager().currentActivity().getWindow().setAttributes(lp);
            }
        });
        return this;
    }

    /**
     * 按手机像素的百分百比
     * @param w
     * @param h
     * @param view
     */
    public BasePopuWindow setShowCenterLocation(float w,float h,View view){
        if (mPopupWindow!=null){
            DisplayMetrics metric = new DisplayMetrics();
            App.getActivityManager().currentActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
            //像素
            float width=metric.widthPixels*w;
            float heigtht=metric.heightPixels*h;
            mPopupWindow.setHeight((int) heigtht);
            mPopupWindow.setWidth((int) width);
            mPopupWindow.setFocusable(isHide);
            mPopupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        }
        return this;
    }

    public BasePopuWindow setShowAsDropDown(View view,float w,float h){

        DisplayMetrics metric = new DisplayMetrics();
        App.getActivityManager().currentActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
        //像素
        float width=metric.widthPixels*w;
        float heigtht=metric.heightPixels*h;
        mPopupWindow.setHeight((int) heigtht);
        mPopupWindow.setWidth((int) width);
        mPopupWindow.setFocusable(isHide);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mPopupWindow.showAsDropDown(view,0,0,Gravity.CENTER);
        }else {
            mPopupWindow.showAsDropDown(view,0,0);
        }
        return this;
    }
    public BasePopuWindow backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp =  App.getActivityManager().currentActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        App.getActivityManager().currentActivity().getWindow().setAttributes(lp);
        return this;
    }
}
