package com.woodslake.matrix.support.crash;

import android.content.Context;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
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
        collectAppInfo(mContext);
        collectDeviceInfo(mContext);
        saveCrashInfoFile(throwable);
        return true;
    }

    private void collectAppInfo(Context context){

    }

    private void collectDeviceInfo(Context context){

    }

    private String saveCrashInfoFile(Throwable throwable){
        return null;
    }

}
