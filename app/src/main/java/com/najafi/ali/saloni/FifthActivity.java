package com.najafi.ali.saloni;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FifthActivity extends AppCompatActivity {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> icons = new ArrayList<>();
    DrawerLayout drawerLayout;
    int num = 0;
    ArrayList<Integer> layoutIds = new ArrayList<>();
    ViewPager viewPager;
    TextView textView4;
    TextView textView2;
    TextView textView3;
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        changeStatusBarColor();
        textView4 = findViewById(R.id.textView4);
        textView2= findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView4.setTypeface(Font.createTypeFaceIransansmobile(this));
        textView2.setTypeface(Font.createTypeFaceIransansmobileMedium(this));
        textView3.setTypeface(Font.createTypeFaceIransansmobileMedium(this));
        textView5.setTypeface(Font.createTypeFaceIransansmobile(this));

        preparingData();
        viewPager = findViewById(R.id.viewpager5);

        SliderPagerAdapter pagerAdapter = new SliderPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);


        listener();
        avoidStatusBarChange();
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

    private void listener() {
        PrepareNavigationList();
        drawerLayout = findViewById(R.id.activityRoot5);
        ImageButton threeLines = findViewById(R.id.action_bar_three_lines5);
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
        layoutIds.add(R.layout.pager1);
        layoutIds.add(R.layout.pager2);
        layoutIds.add(R.layout.pager3);
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
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(FifthActivity.this, NinthActivity.class));
                        finish();
                        break;
                    case 3:
                        startActivity(new Intent(FifthActivity.this, ThirdActivity.class));
                        finish();
                        break;
                    case 4:
                        startActivity(new Intent(FifthActivity.this, FourthActivity.class));
                        finish();
                        break;
                    case 5:
                        break;

                }
            }
        });
    }

    class SliderPagerAdapter extends PagerAdapter {

        Context context;

        public SliderPagerAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = LayoutInflater.from(context).inflate(layoutIds.get(position), container, false);

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layoutIds.size();
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }


}
