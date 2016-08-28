package com.ezio.one;

import android.os.Handler;
import android.os.Bundle;

import common.BaseActivity;

public class InitActivity extends BaseActivity {
    private final static int SPLASH_DISPLAY_LENGTH = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppContext.getInstance().redirectToActivity(InitActivity.this,MainActivity.class);
            }
        },SPLASH_DISPLAY_LENGTH);

    }
}
