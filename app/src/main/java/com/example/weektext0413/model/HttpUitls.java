package com.example.weektext0413.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpUitls<T>{

    private  OkHttpClient okHttpClient;

    private HttpUitls(){
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LogginIntecepter())
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    private  static  class  HttpUtilsInstansce{
        private  static  HttpUitls httpUitls=new HttpUitls();
    }
    public  static  HttpUitls getInstance(){
        return  HttpUtilsInstansce.httpUitls;
    }


    private  class  LogginIntecepter implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request build = chain.request().newBuilder()
                    .addHeader("userId", "11249")
                    .addHeader("sessionId", "155056366467311249").build();
            RequestBody body = build.body();
            Log.e("lalala",""+body);
            Headers headers = build.headers();
            Response proceed = chain.proceed(build);
            Headers headers1 = proceed.headers();
            return proceed;
        }
    }
    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T t = (T)msg.obj;
            mCallback.onResponse(t);
        }
    };
    private  CallBackData mCallback;
    public  void  getData(String url, final Class<T> tClass, CallBackData callBackData){
        this.mCallback=callBackData;
        Request build = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t =  gson.fromJson(string,tClass);
                Message message = handler.obtainMessage();
                message.obj=t;
                handler.sendMessage(message);
            }
        });
    }
    public  void  postData(String url, final Class<T> tClass,final CallBackData callBackData){
        this.mCallback=callBackData;

        FormBody build1 = new FormBody.Builder().build();

        Request build = new Request.Builder()
                .url(url)
                .post(build1)
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t =  gson.fromJson(string,tClass);
                Message message = handler.obtainMessage();
                message.obj=t;
                handler.sendMessage(message);
            }
        });
    }
    public static boolean isNetworkConnected(Context context){
        if(context!=null){
            ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info!=null){
                return  info.isAvailable();
            }
        }

        return false;
    }

    public  interface  CallBackData<D>{
        public  void  onResponse(D d);
        public  void  onFail(String err);
    }
}
