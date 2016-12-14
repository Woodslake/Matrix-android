package com.woodslake.matrix.support.crash;

import android.content.Context;

import com.woodslake.matrix.support.util.AppInfoUtil;
import com.woodslake.matrix.support.util.DeviceInfoUtil;
import com.woodslake.matrix.support.util.LogUtil;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private final String TAG = CrashHandler.class.getSimpleName();
    private Context mContext;
    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    //CrashHandler实例
    private static final CrashHandler INSTANCE = new CrashHandler();

    private CrashHandler(){}

    public static CrashHandler getInstance(){
        return INSTANCE;
    }

    public void init(Context context){
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if(!handleException(throwable) && mDefaultHandler != null){
            mDefaultHandler.uncaughtException(thread, throwable);
        }else {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(10);
        }

    }

    private boolean handleException(Throwable throwable){
        if(throwable == null){
            return false;
        }
        collectDeviceInfo(mContext);
        collectAppInfo(mContext);
        saveCrashInfoFile(throwable);
        return true;
    }

    private void collectDeviceInfo(Context context){
        String os = DeviceInfoUtil.getDeviceOsVersion();
        int sdk = DeviceInfoUtil.getDeviceSdkVersion();
        String vendor = DeviceInfoUtil.getDeviceVendor();
        String model = DeviceInfoUtil.getDeviceModel();
        LogUtil.i(TAG, String.format("%s,%s,%s,%d", vendor, model, os, sdk));
    }

    private void collectAppInfo(Context context){
        String versionName = AppInfoUtil.getVersionName(context);
        int versionCode = AppInfoUtil.getVersionCode(context);
        LogUtil.i(TAG, String.format("%s,%d", versionName, versionCode));
    }

    private String saveCrashInfoFile(Throwable throwable){
        return null;
    }

}
