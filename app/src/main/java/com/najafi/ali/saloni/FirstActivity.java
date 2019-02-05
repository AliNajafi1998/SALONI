package com.najafi.ali.saloni;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {


    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabItems = new ArrayList<>();

    TextView desc;
    ViewPager viewPager;
    Typeface typeface;
    TabLayout tabLayout;
    SlidePagerAdapter slidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        desc = findViewById(R.id.description);
        viewPager = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.view_tab);


        changeFont();
        preparingData();

        slidePagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(slidePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });


    }


    private void changeFont(){
        typeface = EnglishToPersian.createTypeFace(this);
        desc.setTypeface(typeface);
    }

    private void preparingData() {

        tabItems.add("ثبت نام");
        tabItems.add("ورود");

        fragments.add(new RegisterFragment());//Here The fragments must be added!
        fragments.add(new EnterFragment());

    }

    class SlidePagerAdapter extends FragmentPagerAdapter {
        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabItems.get(position);
        }
    }
}
