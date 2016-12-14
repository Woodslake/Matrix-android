package com.woodslake.matrix.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class AppInfoUtil {

    public static String getApplicationMetaData(Context context, String name){
        if(context == null || TextUtil.isEmpty(name)){
            return null;
        }
        String metaData = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if(packageManager != null){
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
                if(applicationInfo != null && applicationInfo.metaData != null){
                    metaData = applicationInfo.metaData.getString(name);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return metaData;
    }

}
