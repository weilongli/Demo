package dfy.demo.presenter;

import java.util.HashMap;

import dfy.networklibrary.base.BasePresenter;
import dfy.demo.bean.DetailBean;
import dfy.networklibrary.net.BaseRequest;
import dfy.networklibrary.net.ConstantNet;

/**
 * Created by Admin on 2017/8/31.
 */

public class homepresenter extends BasePresenter<HomeView> {

    public homepresenter(HomeView view){
        getInterfaceUI=view;
    }

    public void homeIndex(){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("page","1");
        hashMap.put("areaId","");
        hashMap.put("dataId","");
        hashMap.put("year","");

        new BaseRequest<DetailBean>()
                .setURL(ConstantNet.LAW_DETAIL)
                .addHttpParams(hashMap)
                .setDataType(DetailBean.class)
                .setIsLoading(true)
                .setIsJsonException(true)
                .requestCodeSuccess(new BaseRequest.NetRequestSuccess<DetailBean>() {
                    @Override
                    public void needResultCode(DetailBean baseBean) {
                        getInterfaceUI.getIndex(baseBean);
                    }
                })
                .netGetRequest();
    }
}
