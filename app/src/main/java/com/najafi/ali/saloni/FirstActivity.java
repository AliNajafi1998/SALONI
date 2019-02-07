package com.najafi.ali.saloni;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

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
        changeStatusBarColor();
        desc = findViewById(R.id.description);
        viewPager = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.view_tab);
        changeFont();
        customActionbar();
        avoidStatusBarChange();

        preparingData();

        slidePagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(slidePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.beginFakeDrag();
    }


    private void changeFont() {
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

    private void avoidStatusBarChange() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    changeStatusBarColor();

                } else {
                    changeStatusBarColor();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                        window.setStatusBarColor(Color.parseColor("#1EB83C"));
                    }
                }
            }
        });

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    private void customActionbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageButton back = toolbar.findViewById(R.id.action_bar_back);
        ImageButton threeLines = toolbar.findViewById(R.id.action_bar_three_lines);
        TextView textView = toolbar.findViewById(R.id.app_name);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(FirstActivity.this,"Back Button Clicked!",Toast.LENGTH_SHORT).show();
            }
        });
        threeLines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,"Three Lines Clicked!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
