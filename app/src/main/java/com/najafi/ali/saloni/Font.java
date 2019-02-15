package com.najafi.ali.saloni;

import android.content.Context;
import android.graphics.Typeface;

public class Font {
    public static Typeface createTypeFaceIransansmobile(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansmobile.ttf");
    }
    public static Typeface createTypeFaceIransansmobileBold(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansmobile_bold.ttf");
    }
    public static Typeface createTypeFaceIransansmobileLight(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansmobile_light.ttf");
    }
    public static Typeface createTypeFaceIransansmobileMedium(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansmobile_medium.ttf");
    }
    public static Typeface createTypeFaceIransansmobileUltralight(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansmobile_ultralight.ttf");
    }

    public static Typeface createTypeFace2(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "superclarendonbold.ttf");
    }
}
