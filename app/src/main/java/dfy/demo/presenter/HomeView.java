package dfy.demo.presenter;

import dfy.networklibrary.base.BaseView;
import dfy.demo.bean.DetailBean;

/**
 * Created by Admin on 2017/8/31.
 */

public interface HomeView extends BaseView {

    void getIndex(DetailBean homeBean);
}
