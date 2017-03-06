package com.woodslake.library.util;

/**
 * Created by Woodslake on 2016/12/14.
 */

public class TextUtil {

    public static boolean isEmpty(final String str){
        if(str == null || str.equals("")){
            return true;
        }else {
            return false;
        }
    }
}
