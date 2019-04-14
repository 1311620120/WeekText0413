package com.example.weektext0413.presenter;

import com.example.weektext0413.model.Constantes;
import com.example.weektext0413.model.HttpUitls;
import com.example.weektext0413.model.JsonBean;
import com.example.weektext0413.view.activity.MainActivity;
import com.example.weektext0413.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 16:52:41
 * @Description:
 */
public class MainPresenter extends BasePresenter<IMainView<JsonBean>> {

    private final HttpUitls instance;

    public MainPresenter(MainActivity mainActivity){
        instance = HttpUitls.getInstance();

     }
     public  void  ShowData(){
        instance.getData(Constantes.SHOW, JsonBean.class, new HttpUitls.CallBackData() {
            @Override
            public void onResponse(Object o) {
                 getView().onSuccess((JsonBean)o);
            }

            @Override
            public void onFail(String err) {

            }
        });
     }
}
