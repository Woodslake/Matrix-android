package com.woodslake.matrix.support.analytics;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;
import com.woodslake.matrix.support.util.AppInfoUtil;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class AnalyticsManager {
    private static final String AppKey = "UMENG_APPKEY";
    private static final String ChannelId = "UMENG_CHANNEL";

    public static void init(final Context context){
        String appKey = AppInfoUtil.getApplicationMetaData(context, AppKey);
        String channelId = AppInfoUtil.getApplicationMetaData(context, ChannelId);
        init(context, appKey, channelId);
    }

    public static void init(final Context context, final String appKey, final String channelId){
        MobclickAgent.UMAnalyticsConfig uMAnalyticsConfig = new MobclickAgent.UMAnalyticsConfig(context, appKey, channelId);
        MobclickAgent.startWithConfigure(uMAnalyticsConfig);
    }

    public static void onResume(Context context){
        MobclickAgent.onResume(context);
    }

    public static void onPause(Context context){
        MobclickAgent.onResume(context);
    }

}
