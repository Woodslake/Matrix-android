package com.woodslake.matrix.support.util;

import android.util.Log;

import com.woodslake.matrix.BuildConfig;

/**
 * Created by Woodslake on 2016/12/13.
 */

public class LogUtil {
    private static final int N = 0;

    public static int v(String tag, String msg) {
        return BuildConfig.DEBUG ? Log.v(tag, msg) : N;
    }

    public static int v(String tag, String msg, Throwable tr) {
        return BuildConfig.DEBUG ? Log.v(tag, msg, tr) : N;
    }

    public static int d(String tag, String msg) {
        return BuildConfig.DEBUG ? Log.d(tag, msg) : N;
    }

    public static int d(String tag, String msg, Throwable tr) {
        return BuildConfig.DEBUG ? Log.d(tag, msg, tr) : N;
    }

    public static int i(String tag, String msg) {
        return BuildConfig.DEBUG ? Log.i(tag, msg) : N;
    }

    public static int i(String tag, String msg, Throwable tr) {
        return BuildConfig.DEBUG ? Log.i(tag, msg, tr) : N;
    }

    public static int w(String tag, String msg) {
        return BuildConfig.DEBUG ? Log.w(tag, msg) : N;
    }

    public static int w(String tag, String msg, Throwable tr) {
        return BuildConfig.DEBUG ? Log.w(tag, msg, tr) : N;
    }

    public static int w(String tag, Throwable tr) {
        return BuildConfig.DEBUG ? Log.w(tag, tr) : N;
    }

    public static int e(String tag, String msg) {
        return BuildConfig.DEBUG ? Log.e(tag, msg) : N;
    }

    public static int e(String tag, String msg, Throwable tr) {
        return BuildConfig.DEBUG ? Log.e(tag, msg, tr) : N;
    }
}
