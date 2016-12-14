package com.woodslake.matrix;

import android.app.Application;

import com.woodslake.matrix.support.analytics.AnalyticsManager;
import com.woodslake.matrix.support.crash.CrashHandler;
import com.woodslake.matrix.util.LogUtil;

/**
 * Created by Woodslake on 2016/12/13.
 */

public class MainApplication extends Application {
    private final String TAG = MainApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i(TAG, "onCreate");
        CrashHandler.getInstance().init(this);
        AnalyticsManager.init(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtil.i(TAG, "onLowMemory");
    }
}
