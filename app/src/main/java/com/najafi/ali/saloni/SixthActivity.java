package com.najafi.ali.saloni;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SixthActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    int num = 0;
    Typeface typeface;
    TextView appName;
    TextView suggestionTextView;
    TextView chooseSubjextView;
    EditText txt0;
    AppCompatSpinner spinner;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> icons = new ArrayList<>();
    private ArrayList<String> spinnerArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        init();

        changeFont();
        preparingData();
        customActionbar();
        spinnerAdapter();
        avoidStatusBarChange();
    }

    private void init() {
        appName = findViewById(R.id.app_name6);
        suggestionTextView = findViewById(R.id.suggestion_text);
        chooseSubjextView = findViewById(R.id.choose_subject);
        spinner = findViewById(R.id.spinner);
        txt0 = findViewById(R.id.txt0);
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

        spinnerArray.add("");
        spinnerArray.add("شکایت");
        spinnerArray.add("تشکر");


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

    private void changeFont() {
        typeface = Font.createTypeFace2(this);
        appName.setTypeface(typeface);
        suggestionTextView.setTypeface(Font.createTypeFaceIransansmobileMedium(this));
        chooseSubjextView.setTypeface(Font.createTypeFaceIransansmobile(this));
        txt0.setTypeface(Font.createTypeFaceIransansmobile(this));
    }

    private void customActionbar() {
        drawerLayout = findViewById(R.id.activityRoot6);
        NavigationBarAdapter adapter = new NavigationBarAdapter(this, names, icons);
        ListView list = findViewById(R.id.listOfNav);
        list.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        ImageButton back = toolbar.findViewById(R.id.action_bar_back6);
        ImageButton threeLines = toolbar.findViewById(R.id.action_bar_three_lines6);
        changeFont();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SixthActivity.this, "Back Button Clicked!", Toast.LENGTH_SHORT).show();
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
                        startActivity(new Intent(SixthActivity.this, FourthActivity.class));
                        finish();
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(SixthActivity.this, NinthActivity.class));
                        finish();
                        break;
                    case 3:
                        startActivity(new Intent(SixthActivity.this, ThirdActivity.class));
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

    public void spinnerAdapter() {
        SpinnerAdapter adapter = new com.najafi.ali.saloni.SpinnerAdapter(this, spinnerArray);
        spinner.setAdapter(adapter);



    }

}

