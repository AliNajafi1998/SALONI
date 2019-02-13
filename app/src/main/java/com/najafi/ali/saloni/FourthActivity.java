package com.najafi.ali.saloni;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    int num = 0;
    TextView appName;
    Typeface typeface2;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> icons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        changeStatusBarColor();
        appName = findViewById(R.id.app_name4);



        preparingData();
        customActionbar();
        prepareList();
        avoidStatusBarChange();
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
        typeface2 = EnglishToPersian.createTypeFace2(this);
        appName.setTypeface(typeface2);
    }

    private void customActionbar() {
        prepareNavigationBar();
        drawerLayout = findViewById(R.id.activityRoot4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        ImageButton back = toolbar.findViewById(R.id.action_bar_back4);
        ImageButton threeLines = toolbar.findViewById(R.id.action_bar_three_lines4);
        changeFont();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FourthActivity.this, "Back Button Clicked!", Toast.LENGTH_SHORT).show();
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

    private void prepareNavigationBar() {
        NavigationBarAdapter adapter = new NavigationBarAdapter(this, names, icons);
        ListView list = findViewById(R.id.listOfNav);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO the intents of the NavigationBar
                switch (position){
                    case 0:
                        startActivity(new Intent(FourthActivity.this,FirstActivity.class));
                        finish();
                        break;
                    case 1:
                        break;
                    case 2:

                        break;
                    case 3:
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
        LVAdapter adapter = new LVAdapter(this,Complex.initializeData());
        ListView listView = findViewById(R.id.list_view_fourth);
        listView.setAdapter(adapter);
    }
}
