package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GroupViewClockTime extends ConstraintLayout {

    private View rootView;
    private ImageView img_check;
    private TextView txtTime;
    private TextView txtStartTime;
    private TextView txtEndTime;
    private String time;
    private String startTime;
    private String endTime;

    public GroupViewClockTime(Context context) {
        super(context);
        init(context);
    }

    public GroupViewClockTime(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GroupViewClockTime(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupViewClockTime, defStyleAttr, 0);

        time = ta.getString(R.styleable.GroupViewClockTime_txt_time);
        startTime = ta.getString(R.styleable.GroupViewClockTime_txt_start_time);
        endTime = ta.getString(R.styleable.GroupViewClockTime_txt_end_time);
        ta.recycle();


        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.clock_item, this);
        img_check = rootView.findViewById(R.id.img_check);
        txtTime = rootView.findViewById(R.id.txt_time);
        txtStartTime = rootView.findViewById(R.id.txt_start_time);
        txtEndTime = rootView.findViewById(R.id.txt_end_time);
        changeFont(context);
        txtTime.setText(time);
        txtStartTime.setText(EnglishToPersian.englishToPersian(startTime));
        txtEndTime.setText(EnglishToPersian.englishToPersian(endTime));


    }

    private void changeFont(Context context) {
        Typeface typeface = Font.createTypeFaceIransansmobile(context);
        txtTime.setTypeface(typeface);
        txtStartTime.setTypeface(typeface);
        txtEndTime.setTypeface(typeface);
    }

    public void changeColor(boolean change, Context context) {
        if (change) {
            img_check.setColorFilter(ContextCompat.getColor(context, R.color.Green), android.graphics.PorterDuff.Mode.SRC_IN);
            txtTime.setTextColor(context.getResources().getColor(R.color.Green));
            txtStartTime.setTextColor(context.getResources().getColor(R.color.Green));
            txtEndTime.setTextColor(context.getResources().getColor(R.color.Green));
        } else {
            img_check.setColorFilter(Color.parseColor("#747474"), android.graphics.PorterDuff.Mode.SRC_IN);
            txtTime.setTextColor(Color.parseColor("#747474"));
            txtStartTime.setTextColor(Color.parseColor("#747474"));
            txtEndTime.setTextColor(Color.parseColor("#747474"));
        }
        invalidate();
        requestLayout();
    }
}
