package com.example.weektext0413.presenter;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 16:49:43
 * @Description:
 */
public class BasePresenter<V> {
     private  V view;

    public void setView(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    public  void detach(){

       this.view=null;
    }
}
