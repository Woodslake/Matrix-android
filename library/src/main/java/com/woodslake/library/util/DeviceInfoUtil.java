package com.woodslake.library.util;

import android.os.Build;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class DeviceInfoUtil {

    /**
     * 手机制造商
     * @return
     */
    public static String getDeviceVendor(){
        return Build.MANUFACTURER;
    }

    /**
     * 手机型号
     * @return
     */
    public static String getDeviceModel(){
        return Build.MODEL;
    }

    /**
     * Android OS版本号
     * @return
     */
    public static String getAndroidOs(){
        return Build.VERSION.RELEASE;
    }

    /**
     * Android sdk版本号
     * @return
     */
    public static int getAndroidSdk(){
        return Build.VERSION.SDK_INT;
    }

}
