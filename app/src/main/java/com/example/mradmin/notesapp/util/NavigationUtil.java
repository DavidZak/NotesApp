package com.example.mradmin.notesapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class NavigationUtil {

    //start activity
    public static void startActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Activity activity) {
        Intent intent = new Intent(context, activity.getClass());
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }

    //start single top activity
    public static void startActivitySingleTop(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public static void startActivitySingleTop(Context context, Activity activity) {
        Intent intent = new Intent(context, activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public static void startActivitySingleTop(Context context, Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}
