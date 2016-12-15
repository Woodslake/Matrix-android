package com.woodslake.matrix;

import android.app.Application;
import android.util.Log;

import com.woodslake.support.analytics.AnalyticsManager;
import com.woodslake.support.crash.CrashHandler;

/**
 * Created by Woodslake on 2016/12/13.
 */

public class MainApplication extends Application {
    private final String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
        CrashHandler.getInstance().init(this);
        AnalyticsManager.init(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "onLowMemory");
    }

}
