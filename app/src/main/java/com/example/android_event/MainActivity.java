package com.example.android_event;

import android.content.Context;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.android_event.Views.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private NavigationView mNavigationView;
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout = findViewById(R.id.layout);
        mNavigationView = findViewById(R.id.nagivationView);
        mNavigationView.setOnClickListener(this);

        NavigationView navigationView = new NavigationView(this);
        navigationView.setBgColor(getResources().getColor(R.color.colorAccent));
        navigationView.setRightTitle("按钮");
        navigationView.setTitle("标题");
        navigationView.setOnClickListener(this);
        navigationView.setId(R.id.navigation);
        navigationView.setOnClickListener(this);
        mConstraintLayout.addView(navigationView);

        ConstraintSet set = new ConstraintSet();
        set.connect(navigationView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(navigationView.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);
        set.connect(navigationView.getId(), ConstraintSet.TOP, R.id.nagivationView, ConstraintSet.BOTTOM);
        set.connect(navigationView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
        set.setMargin(navigationView.getId(), 1, 300);
        set.setMargin(navigationView.getId(), 2, 300);
        set.constrainWidth(navigationView.getId(), ConstraintSet.MATCH_CONSTRAINT);
        set.constrainHeight(navigationView.getId(), 300);
        set.applyTo(mConstraintLayout);

        Log.d("MainActivity", "屏幕的宽度"+MainActivity.getScreenWidth(this));
        Log.d("MainActivity", "屏幕的高度"+MainActivity.getScreenHeight(this));
    }

    @Override
    public void onClick(View v) {
        Log.d("MainActivity", "点击了左侧按钮");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    //获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }
    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }
}
