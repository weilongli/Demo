package dfy.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import dfy.demo.presenter.HomeView;
import dfy.demo.presenter.homepresenter;
import dfy.networklibrary.base.BaseActivity;
import dfy.demo.bean.DetailBean;
import dfy.networklibrary.base.BasePopuWindow;

import static dfy.demo.ApplictionDemo.getActivityManager;


public class MainActivity extends BaseActivity implements HomeView {
    private TextView tv;
    private TextView button;
    private LinearLayout mLinearLayout;
    private homepresenter mHomepresenter;

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tv = (TextView) findViewById(R.id.tv);
        button = (TextView) findViewById(R.id.button);
        mLinearLayout = (LinearLayout) findViewById(R.id.lin);
        getActivityManager().pushActivity(this);
        mHomepresenter = new homepresenter(this);
        mHomepresenter.homeIndex();
    }

    @Override
    public void initData() {

    }


    @Override
    public void getIndex(DetailBean homeBean) {

        tv.setText(homeBean.toString() + "数据·");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View inflate = LayoutInflater.from(mContext).inflate(R.layout.pouwidow, null, false);
                BasePopuWindow basePopuWindow = new BasePopuWindow();
                basePopuWindow.getInstanceWindow(inflate)
                        .setShowAsDropDown(button, 0.8f, 0.5f)
                        .backgroundAlpha(0.5f);
            }
        });
    }
}
