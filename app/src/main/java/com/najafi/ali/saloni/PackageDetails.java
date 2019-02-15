package com.najafi.ali.saloni;

import java.util.ArrayList;
import java.util.List;

public class PackageDetails {
    private String name;
    private String cost;
    private int bg;
    public PackageDetails(String name, String cost,int bg) {
        this.name = name;
        this.cost = cost;
        this.bg = bg;
    }

    public String getName() {
        return name;
    }

    public int getBg() {
        return bg;
    }

    public String getCost() {
        return cost;
    }
    private static List<PackageDetails> list;
    public static List<PackageDetails> initializePackageDetails(){
        list = new ArrayList<>();
        list.add(new PackageDetails("بسته ۳ ماهه","210000",R.drawable.a));
        list.add(new PackageDetails("بسته ۶ ماهه","390000",R.drawable.b));
        list.add(new PackageDetails("بسته ۹ ماهه","510000",R.drawable.c));
        return list;
    }
}
