package com.najafi.ali.saloni;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public class EnglishToPersian {
    public static Map<String, String> numbers;

    public static String englishToPersian(String englishText) {
        numbers = new HashMap<>();
        numbers.put("0", "۰");
        numbers.put("1", "۱");
        numbers.put("2", "۲");
        numbers.put("3", "۳");
        numbers.put("4", "۴");
        numbers.put("5", "۵");
        numbers.put("6", "۶");
        numbers.put("7", "۷");
        numbers.put("8", "۸");
        numbers.put("9", "۹");

        if (englishText.equals("")) return "";
        StringBuilder persianText = new StringBuilder();

        for (int i = 0; i < englishText.length(); i++) {

            if (numbers.containsKey(String.valueOf(englishText.charAt(i)))) {
                persianText.append(numbers.get(String.valueOf(englishText.charAt(i))));
            }
        }
        return persianText.toString();
    }


    public static Typeface createTypeFace(Context context){
        return Typeface.createFromAsset(context.getResources().getAssets(), "iransansweb.ttf");
    }
}
