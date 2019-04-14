package com.example.weektext0413.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weektext0413.R;
import com.example.weektext0413.greendao.gen.GreenBeanDao;
import com.example.weektext0413.model.GreenBean;
import com.example.weektext0413.model.JsonBean;
import com.example.weektext0413.model.app;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 17:02:41
 * @Description:
 */
public class ShowAdapter extends RecyclerView.Adapter <ShowAdapter.ViewHolder>{
    Context context; List<JsonBean.ResultBean> result;
    private List<GreenBean> list;
    private List<GreenBean> listes;
    private GreenBean been;
    GreenBeanDao greenBeanDao;

    public ShowAdapter(Context context, List<JsonBean.ResultBean> result) {
        this.context=context;
        this.result=result;
        greenBeanDao = app.daoSession.getGreenBeanDao();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ilist, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
         viewHolder.img.setImageURI(result.get(i).getImageUrl());
         viewHolder.name.setText(result.get(i).getName());
         viewHolder.price.setText(result.get(i).getSummary()+"");

        greenBeanDao.deleteAll();
//        been = new GreenBean();
//        been.setId((long) i);
//        been.setImageUrl(result.get(i).getImageUrl());
//        been.setName(result.get(i).getName());
//        been.setSummary(result.get(i).getSummary());
//        greenBeanDao.insert(been);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {




            @Override
             public void onClick(View v) {

                 //全部查出来

                list = greenBeanDao.loadAll();

                 been = list.get(i);
                 been.setName("我是修改过得名字");
                  greenBeanDao.update(been);

                listes = greenBeanDao.loadAll();
                 for(GreenBean greenBeanes : listes){
                     long key = greenBeanDao.getKey(greenBeanes);
                     Log.e("tag" ,"key = " + key + " name = " + greenBeanes.getName());
                 }


             }
         });
    }



    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

          SimpleDraweeView img;
          TextView name;
          TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
