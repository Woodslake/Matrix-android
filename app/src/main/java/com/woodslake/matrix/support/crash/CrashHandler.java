package com.woodslake.matrix.support.crash;

import android.content.Context;
import android.util.Log;

import com.woodslake.library.util.AppInfoUtil;
import com.woodslake.library.util.DeviceInfoUtil;

import java.util.HashMap;
import java.util.Map;

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
    //crash数据
    private final Map mCrashMap = new HashMap();
    private final String deviceVendor = "deviceVendor";
    private final String deviceModel = "deviceModel";
    private final String androidOs = "androidOs";
    private final String androidSdk = "androidSdk";
    private final String packageName = "packageName";
    private final String versionName = "versionName";
    private final String versionCode = "versionCode";


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
        collectDeviceInfo();
        collectAppInfo(mContext);
        saveCrashInfoFile(throwable);
        Log.i(TAG, mCrashMap.toString());
        return true;
    }

    private void collectDeviceInfo(){
        String deviceVendor = DeviceInfoUtil.getDeviceVendor();
        String deviceModel = DeviceInfoUtil.getDeviceModel();
        String androidOs = DeviceInfoUtil.getAndroidOs();
        int androidSdk = DeviceInfoUtil.getAndroidSdk();
        mCrashMap.put(this.deviceVendor, deviceVendor);
        mCrashMap.put(this.deviceModel, deviceModel);
        mCrashMap.put(this.androidOs, androidOs);
        mCrashMap.put(this.androidSdk, androidSdk);
    }

    private void collectAppInfo(Context context){
        String packageName = AppInfoUtil.getPackageName(context);
        String versionName = AppInfoUtil.getVersionName(context);
        int versionCode = AppInfoUtil.getVersionCode(context);
        mCrashMap.put(this.packageName, packageName);
        mCrashMap.put(this.versionName, versionName);
        mCrashMap.put(this.versionCode, versionCode);
    }

    private String saveCrashInfoFile(Throwable throwable){
        return null;
    }

}
