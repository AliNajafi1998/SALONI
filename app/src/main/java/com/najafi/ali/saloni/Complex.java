package com.najafi.ali.saloni;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Complex {
    private String complexName;
    private String complexNo;
    private String time;
    private String startTime;
    private String endTime;
    private String date;
    private String cost;

    public Complex(String complexName, String complexNo, String time, String startTime,
                   String endTime, String date, String cost) {
        this.complexName = complexName;
        this.complexNo = complexNo;
        this.time = time;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.cost = cost;
    }


    public String seperator(String text) {
        List<String> myNumbers = Arrays.asList(
                NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(text)).split(","));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myNumbers.size(); i++) {
            sb.append(myNumbers.get(i));
            if (i != (myNumbers.size() - 1)) sb.append(",");
        }
        return sb.toString();
    }

    private static List<Complex> complex;

    public static List<Complex> initializeData() {
        complex = new ArrayList<>();
        complex.add(new Complex("مجتمع ورزشی افق لاله", "یک", "صبح", "08:00", "12:00", "96/12/08", "24000"));
        complex.add(new Complex("مجتمع ورزشی میلاد نور", "چهار", "صبح", "08:00", "12:00", "96/12/08", "44000"));
        complex.add(new Complex("مجتمع ورزشی لاله", "یک", "ظهر", "08:00", "12:00", "96/12/08", "50000"));
        complex.add(new Complex("مجتمع ورزشی لاله", "یک", "ظهر", "08:00", "12:00", "96/12/08", "50000"));
        complex.add(new Complex("مجتمع ورزشی لاله", "یک", "ظهر", "08:00", "12:00", "96/12/08", "50000"));
        return complex;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getComplexNo() {
        return complexNo;
    }

    public String getTime() {
        return time;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDate() {
        return date;
    }

    public String getCost() {
        return cost;
    }

}
