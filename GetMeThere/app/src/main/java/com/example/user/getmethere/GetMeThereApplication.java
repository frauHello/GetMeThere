package com.example.user.getmethere;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

/**
 * Created by sonia on 5/31/17.
 */

public class GetMeThereApplication extends Application {

    private static GetMeThereApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static GetMeThereApplication getInstance() {
        return instance;
    }

   /* @Nullable
    public static SharedPreferences getSharedPreferences() {
        GetMeThereApplication application = GetMeThereApplication.getInstance();
        if (application == null) return null;
        return application.getBaseContext().getSharedPreferences(Constants.SharedConfig.name, Context.MODE_PRIVATE);
    }*/
}
