package com.woodslake.matrix.support.util;

import android.os.Build;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class DeviceInfoUtil {

    /**
     * Android OS版本号
     * @return
     */
    public static String getDeviceOsVersion(){
        return Build.VERSION.RELEASE;
    }

    /**
     * Android sdk版本号
     * @return
     */
    public static int getDeviceSdkVersion(){
        return Build.VERSION.SDK_INT;
    }

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

}
