package com.example.weektext0413.model;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.weektext0413.greendao.gen.DaoMaster;
import com.example.weektext0413.greendao.gen.DaoSession;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * @Auther: 白俊岭
 * @Date: 2019/4/12 15:25:30
 * @Description:
 */
public class app extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //创建数据库shop.db
        DaoMaster.DevOpenHelper devOpenHelper =new DaoMaster.DevOpenHelper(this,"mybd");
        //获取可写数据库
        SQLiteDatabase sqLiteDatabase =devOpenHelper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster =new DaoMaster(sqLiteDatabase);
        //获取dao对象管理者
        daoSession = daoMaster.newSession();
        
        //设置Fresco需要配置缓存路径和缓存大小
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("kkk")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .setMaxCacheSize(100*ByteConstants.MB)
                .setMaxCacheSizeOnLowDiskSpace(60*ByteConstants.MB)
                .setMaxCacheSizeOnVeryLowDiskSpace(20*ByteConstants.MB)
                .build();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this);




    }
}
