package com.najafi.ali.saloni;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.GravityCompat;
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

public class ThirdActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> icons = new ArrayList<>();
    int num = 0;
    Typeface typeface2;
    TextView appName;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        changeStatusBarColor();
        init();


        changeFont();
        preparingData();
        customActionbar();
        prepareList();
        avoidStatusBarChange();
    }

    private void init() {
        appName = findViewById(R.id.app_name3);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
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

    }

    private void changeFont() {
        typeface2 = Font.createTypeFace2(this);
        appName.setTypeface(typeface2);
        txt1.setTypeface(Font.createTypeFaceIransansmobileBold(this));
        txt2.setTypeface(Font.createTypeFaceIransansmobileBold(this));
        txt3.setTypeface(Font.createTypeFaceIransansmobileLight(this));
        txt4.setTypeface(Font.createTypeFaceIransansmobileBold(this));
        txt5.setTypeface(Font.createTypeFaceIransansmobileMedium(this));
        txt6.setTypeface(Font.createTypeFaceIransansmobileMedium(this));


    }

    private void customActionbar() {
        PrepareNavigationList();

        drawerLayout = findViewById(R.id.activityRoot3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        ImageButton back = toolbar.findViewById(R.id.action_bar_back3);
        ImageButton threeLines = toolbar.findViewById(R.id.action_bar_three_lines3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Back Button Clicked!", Toast.LENGTH_SHORT).show();
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
                        startActivity(new Intent(ThirdActivity.this, FourthActivity.class));
                        finish();
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(ThirdActivity.this, NinthActivity.class));
                        finish();
                        break;
                    case 3:
                        startActivity(new Intent(ThirdActivity.this, ThirdActivity.class));
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
    private void prepareList(){
        PackageAdapter adapter = new PackageAdapter(this,PackageDetails.initializePackageDetails());
        ListView listView = findViewById(R.id.packageListView);
        listView.setAdapter(adapter);
    }
}
