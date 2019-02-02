package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class GroupViewTwo2FirstActivity extends ConstraintLayout {


    View rootView;
    TextView tvStart;
    TextView tvEnd;
    TextView tv1, tv2;
    String startTime;
    String endTime;

    public GroupViewTwo2FirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewTwo2FirstActivity(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context);
    }

    public GroupViewTwo2FirstActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupViewTwo2FirstActivity, defStyleAttr, 0);

        startTime = ta.getString(R.styleable.GroupViewTwo2FirstActivity_start_time);
        endTime = ta.getString(R.styleable.GroupViewTwo2FirstActivity_end_time);

        ta.recycle();
        init(context);
    }

    private void init(Context context) {

        rootView = inflate(context, R.layout.group_view_two_2_first_activity, this);

        tvStart = rootView.findViewById(R.id.tv_start);
        tvEnd = rootView.findViewById(R.id.tv_end);
        tv1 = rootView.findViewById(R.id.time_from_txt);
        tv2 = rootView.findViewById(R.id.tv_to);


        tv2.setText("تا");
        tv1.setText("ازساعت:");

        Typeface typeface = EnglishToPersian.createTypeFace(context);
        tv1.setTypeface(typeface);
        tv2.setTypeface(typeface);
        tvStart.setTypeface(typeface);
        tvEnd.setTypeface(typeface);

        tvStart.setText(EnglishToPersian.englishToPersian(startTime));
        tvEnd.setText(EnglishToPersian.englishToPersian(endTime));


    }

}
