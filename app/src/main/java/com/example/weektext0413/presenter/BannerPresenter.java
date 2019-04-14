package com.example.weektext0413.presenter;

import android.util.Log;

import com.example.weektext0413.model.BannerJson;
import com.example.weektext0413.model.Constantes;
import com.example.weektext0413.model.HttpUitls;
import com.example.weektext0413.view.activity.MainActivity;
import com.example.weektext0413.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 18:53:17
 * @Description:
 */
public class BannerPresenter extends BasePresenter<IMainView<BannerJson>> {

    private final HttpUitls instance;

    public  BannerPresenter(MainActivity mainActivity){
        instance = HttpUitls.getInstance();
    }
    public void   BannerData(){
            instance.getData(Constantes.Banner, BannerJson.class, new HttpUitls.CallBackData() {
                @Override
                public void onResponse(Object o) {
                     getView().onSuccess(o);

                }

                @Override
                public void onFail(String err) {

                }
            });
    }
}
