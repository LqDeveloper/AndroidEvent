package com.example.android_event.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android_event.R;

public class NavigationView extends LinearLayout {
    private ImageView mBackImageView;
    private TextView mTitleTextView;
    private TextView mRightTextView;

    private String title;
    private String rightTitle;
    private int bgColor;

    public NavigationView(Context context) {
        this(context, null, 0);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, @Nullable AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.navigation_view_layout, this);
        mBackImageView = findViewById(R.id.backImageView);
        mTitleTextView = findViewById(R.id.titleTextView);
        mRightTextView = findViewById(R.id.rigthTextView);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationView);
        if (typedArray == null) return;

        title = typedArray.getString(R.styleable.NavigationView_title);
        rightTitle = typedArray.getString(R.styleable.NavigationView_rightTitle);
        bgColor = typedArray.getColor(R.styleable.NavigationView_bgColor,0);
        setTitle(title);
        setRightTitle(rightTitle);
        setBackgroundColor(bgColor);
    }

    public void setBackListener(View.OnClickListener listener) {
        mBackImageView.setOnClickListener(listener);
    }

    public void setTitle(String title) {
        mTitleTextView.setText(title);
    }

    public void setRightTitle(String rightTitle) {
        mRightTextView.setText(rightTitle);
    }

    public void setBgColor(int color){
        this.setBackgroundColor(color);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return  false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MainActivity","拦截点击事件");
        return false;
    }
}
