package com.woodslake.matrix.support.cache;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by Woodslake on 2016/12/13.
 */

public class ImageLoader {

    public static RequestManager with(Context context){
        return Glide.with(context);
    }

    public static RequestManager with(Activity activity){
        return Glide.with(activity);
    }

    public static RequestManager with(FragmentActivity activity){
        return Glide.with(activity);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static RequestManager with(android.app.Fragment fragment){
        return Glide.with(fragment);
    }

    public static RequestManager with(Fragment fragment){
        return Glide.with(fragment);
    }

}
