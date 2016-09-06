package com.ezio.one;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Ezio on 2016/8/28.
 */
public class AppContext extends Application {
    private static AppContext APP_CONTEXT;

    public static AppContext getInstance() {
        return APP_CONTEXT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        APP_CONTEXT = this;

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
//                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                //其他配置
//                .build();
//
//        OkHttpUtils.initClient(okHttpClient);

    }

    public <T extends Activity> void jumpToActivity(Context context, Class<T> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
    public <T extends Activity> void jumpToActivityForResult(Context context, Class<T> clazz) {
        Intent intent = new Intent(context, clazz);
        ((Activity)context).startActivityForResult(intent, 0x04);
    }
    public <T extends Activity> void jumpToActivityWithExtraForResult(Context context, Class<T> clazz, Map<String, String> params) {
        Intent intent = new Intent(context, clazz);
        Iterator it = params.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            String value = params.get(key);
            intent.putExtra(key, value);
        }
        ((Activity)context).startActivityForResult(intent, 0x04);
    }
    public <T extends Activity> void jumpToActivityWithExtra(Context context, Class<T> clazz, Map<String, String> params) {
        Intent intent = new Intent(context, clazz);
        Iterator it = params.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            String value = params.get(key);
            intent.putExtra(key, value);
        }
        context.startActivity(intent);
    }
    public <T extends Activity> void redirectToActivity(Context context, Class<T> clazz) {
        Intent intent = new Intent(context, clazz);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
