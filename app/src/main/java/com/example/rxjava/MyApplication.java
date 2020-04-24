package com.example.rxjava;

import android.app.Application;

public class MyApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://api.github.com/"))
                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
