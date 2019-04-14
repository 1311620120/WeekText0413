package com.example.weektext0413.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.weektext0413.R;
import com.example.weektext0413.model.BannerJson;
import com.example.weektext0413.model.HttpUitls;
import com.example.weektext0413.model.JsonBean;
import com.example.weektext0413.presenter.BannerPresenter;
import com.example.weektext0413.presenter.MainPresenter;
import com.example.weektext0413.view.adapter.ShowAdapter;
import com.example.weektext0413.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements IMainView {
    ArrayList<String> list = new ArrayList<>();

    @BindView(R.id.recycler)
    XRecyclerView recycler;
    @BindView(R.id.flyBanner)
    FlyBanner flyBanner;



    private MainPresenter mainPresenter;
    private BannerPresenter bannerPresenter;
    private JsonBean jsonBean;
    private int page;
    private ShowAdapter showAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {


        mainPresenter = new MainPresenter(this);
        mainPresenter.ShowData();
        mainPresenter.setView(this);

        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.BannerData();
        bannerPresenter.setView(this);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycler.setLayoutManager(gridLayoutManager);

        recycler.setPullRefreshEnabled(true);
        recycler.setLoadingMoreEnabled(true);
        recycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mainPresenter.ShowData();
                recycler.refreshComplete();
                showAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                mainPresenter.ShowData();
                recycler.loadMoreComplete();

                showAdapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof JsonBean) {
            boolean networkConnected = HttpUitls.isNetworkConnected(this);
            if (networkConnected != false) {
                jsonBean = (JsonBean) o;
                List<JsonBean.ResultBean> result = jsonBean.getResult();
                showAdapter = new ShowAdapter(this, result);
                recycler.setAdapter(showAdapter);
            } else if (networkConnected == false) {
                Toast.makeText(MainActivity.this, "没网了", Toast.LENGTH_SHORT).show();
            }


//            for (JsonBean.ResultBean resultBean :result){
//             //   app.daoSession.deleteAll();
//                GreenBean greenBean =new GreenBean();
//                greenBean.setImageUrl(resultBean.getImageUrl());
//                greenBean.setName(resultBean.getName());
//                greenBean.setSummary(resultBean.getSummary());
//                long insert = app.daoSession.insert(greenBean);
//                Log.e("sss",insert+"");
//            }

        }
        if (o instanceof BannerJson) {

            BannerJson bannerJson = (BannerJson) o;
            final List<BannerJson.ResultBean> banner = bannerJson.getResult();
            for (BannerJson.ResultBean resultBean : banner) {
                list.add(resultBean.getImageUrl());
            }
            flyBanner.setImagesUrl(list);
            flyBanner.startAutoPlay();
        }
    }

    @Override
    public void onFail(String str) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainPresenter != null) {
            mainPresenter.detach();
        }
        if (bannerPresenter != null) {
            bannerPresenter.detach();
        }
    }



}