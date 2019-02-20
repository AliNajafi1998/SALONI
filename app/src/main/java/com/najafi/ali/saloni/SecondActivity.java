package com.najafi.ali.saloni;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    int num = 0;
    TextView appName;
    TextView date;
    TextView signInSignUp;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> icons = new ArrayList<>();
    ULocale locale = new ULocale("fa_IR@calendar=persian");
    DateFormat df = DateFormat.getDateInstance(DateFormat.DATE_FIELD, locale);
    Calendar calendar = Calendar.getInstance(locale);
    ArrayList<Fragment> fragmentsBelow = new ArrayList<>();
    ArrayList<String> tabItemsBelow = new ArrayList<>();
    ViewPager viewPagerBelow;
    TabLayout tabLayoutBelow;
    ClockTimeFragment clockTimeFragment = new ClockTimeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        changeStatusBarColor();
        init();

        changeFont();
        preparingData();
        customActionbar();
        settingDate();
        avoidStatusBarChange();


        SlidePagerAdapterBelow slidePagerAdapter = new SlidePagerAdapterBelow(getSupportFragmentManager());
        viewPagerBelow.setAdapter(slidePagerAdapter);
        tabLayoutBelow.setupWithViewPager(viewPagerBelow);
        viewPagerBelow.beginFakeDrag();

    }

    private void init() {
        appName = findViewById(R.id.app_name2);
        date = findViewById(R.id.date);
        signInSignUp = findViewById(R.id.txt_sign_in_sign_up);
        viewPagerBelow = findViewById(R.id.viewPager2_below);
        tabLayoutBelow = findViewById(R.id.view_tab2);
    }

    private void changeFont() {
        appName.setTypeface(Font.createTypeFace2(this));
        date.setTypeface(Font.createTypeFaceIransansmobileLight(this));
        signInSignUp.setTypeface(Font.createTypeFaceIransansmobileLight(this));
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
        //----------------------------------------------
        tabItemsBelow.add("تایم ها");
        tabItemsBelow.add("اطلاعات");
        tabItemsBelow.add("نظرات");
        //TODO: ADD THE FRAGMENTS TO THE FRAGMENTS LIST
        fragmentsBelow.add(clockTimeFragment);
        fragmentsBelow.add(new ClockTimeFragment());
        fragmentsBelow.add(new ClockTimeFragment());
//        fragmentsBelow.add();
//        fragmentsBelow.add();

    }


    private void customActionbar() {
        PrepareNavigationList();

        drawerLayout = findViewById(R.id.activityRoot2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ImageButton back = toolbar.findViewById(R.id.action_bar_back2);
        ImageButton threeLines = toolbar.findViewById(R.id.action_bar_three_lines2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Back Button Clicked!", Toast.LENGTH_SHORT).show();
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
                switch (position) {
                    case 0:
                        startActivity(new Intent(SecondActivity.this, FourthActivity.class));
                        finish();
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(SecondActivity.this, NinthActivity.class));
                        finish();
                        break;
                    case 3:
                        startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                        finish();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;

                }
            }
        });
    }

    public void previous(View view) {
        calendar.add(Calendar.DATE, -1);
        date.setText(df.format(calendar));
    }

    public void next(View view) {
        calendar.add(Calendar.DATE, 1);
        date.setText(df.format(calendar));

    }

    private void settingDate() {
        date.setText(df.format(calendar));
    }

    class SlidePagerAdapterBelow extends FragmentPagerAdapter {
        SlidePagerAdapterBelow(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentsBelow.get(i);
        }

        @Override
        public int getCount() {
            return fragmentsBelow.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabItemsBelow.get(position);
        }

    }

}
