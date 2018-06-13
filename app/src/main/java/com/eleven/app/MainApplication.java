package com.eleven.app;

import android.app.Application;

import com.eleven.toolkit.ToolKit;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToolKit.init(this);
    }
}
