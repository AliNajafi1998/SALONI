package com.najafi.ali.saloni;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {


    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabItems = new ArrayList<>();

    TextView appName;
    TextView desc;
    ViewPager viewPager;
    Typeface typeface1;
    Typeface typeface2;
    TabLayout tabLayout;
    SlidePagerAdapter slidePagerAdapter;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> icons = new ArrayList<>();
    DrawerLayout drawerLayout;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        changeStatusBarColor();
        appName = findViewById(R.id.app_name);
        desc = findViewById(R.id.description);
        viewPager = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.view_tab);
        changeFont();
        preparingData();
        customActionbar();
        avoidStatusBarChange();

        slidePagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(slidePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.beginFakeDrag();
    }


    private void changeFont() {
        typeface1 = Font.createTypeFaceIransansmobile(this);
        desc.setTypeface(typeface1);
        typeface2 = Font.createTypeFace2(this);
        appName.setTypeface(typeface2);

    }

    private void preparingData() {
        names.add("خانه");
        names.add("ورود و عضویت");
        names.add("بسته های خدماتی");
        names.add("جستجوی پیشرفته");
        names.add("سؤالات متداول");
        names.add("پشتیبانی");
        icons.add(R.drawable.home);
        icons.add(R.drawable.man);
        icons.add(R.drawable.support);
        icons.add(R.drawable.ic_search_black_24dp);
        icons.add(R.drawable.question);
        icons.add(R.drawable.mail);

        tabItems.add("ثبت نام");
        tabItems.add("ورود");
        fragments.add(new RegisterFragment());//Here The fragments must be added!
        fragments.add(new EnterFragment());

    }

    class SlidePagerAdapter extends FragmentPagerAdapter {
        SlidePagerAdapter(FragmentManager fm) {
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
        PrepareNavigationList();

        drawerLayout = findViewById(R.id.activityRoot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageButton back = toolbar.findViewById(R.id.action_bar_back);
        ImageButton threeLines = toolbar.findViewById(R.id.action_bar_three_lines);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "Back Button Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        threeLines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num++;
                if (num % 2 == 1) {
                    drawerLayout.openDrawer(GravityCompat.END);
                } else {
                    drawerLayout.closeDrawer(GravityCompat.END);
                }
            }
        });
    }

    private void PrepareNavigationList() {
        NavigationBarAdapter adapter = new NavigationBarAdapter(this, names, icons);
        ListView list = findViewById(R.id.listOfNav);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                         startActivity(new Intent(FirstActivity.this,NinthActivity.class));
                         finish();
                        break;
                    case 3:
                        startActivity(new Intent(FirstActivity.this,ThirdActivity.class));
                        finish();
                        break;
                    case 4:
                        startActivity(new Intent(FirstActivity.this,FourthActivity.class));
                        finish();
                        break;
                    case 5:
                        break;

                }
            }
        });
    }
}
