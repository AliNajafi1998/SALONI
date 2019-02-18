package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeGroupView extends ConstraintLayout {

    View rootView;
    TextView start;
    TextView to;
    TextView end;
    TextView time;
    ImageView icon;
    private String startTimeText;
    private String endTimeText;
    private String timeText;

    public TimeGroupView(Context context) {
        super(context);
        init(context);
    }

    public TimeGroupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TimeGroupView, defStyleAttr, 0);
        startTimeText = ta.getString(R.styleable.TimeGroupView_startTime);
        endTimeText = ta.getString(R.styleable.TimeGroupView_endTime);
        timeText = ta.getString(R.styleable.TimeGroupView_time);
        ta.recycle();
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.group_view_times, this);
        start = rootView.findViewById(R.id.start_time);
        to = rootView.findViewById(R.id.to);
        end = rootView.findViewById(R.id.end_time);
        time = rootView.findViewById(R.id.time_group);
        icon = rootView.findViewById(R.id.imageView4);

        start.setTypeface(Font.createTypeFaceIransansmobileLight(context));
        to.setTypeface(Font.createTypeFaceIransansmobileLight(context));
        end.setTypeface(Font.createTypeFaceIransansmobileLight(context));
        time.setTypeface(Font.createTypeFaceIransansmobileLight(context));

        start.setText(EnglishToPersian.englishToPersian(startTimeText));
        end.setText(EnglishToPersian.englishToPersian(endTimeText));
        time.setText(timeText);
    }

    public void changeColor(boolean change,Context context){
        if(change){
            icon.setColorFilter(ContextCompat.getColor(context, R.color.Green), android.graphics.PorterDuff.Mode.SRC_IN);
            start.setTextColor(context.getResources().getColor(R.color.Green));
            to.setTextColor(context.getResources().getColor(R.color.Green));
            time.setTextColor(context.getResources().getColor(R.color.Green));
            end.setTextColor(context.getResources().getColor(R.color.Green));
        }else{
            icon.setColorFilter(Color.parseColor("#747474"), android.graphics.PorterDuff.Mode.SRC_IN);
            start.setTextColor(Color.parseColor("#747474"));
            to.setTextColor(Color.parseColor("#747474"));
            time.setTextColor(Color.parseColor("#747474"));
            end.setTextColor(Color.parseColor("#747474"));
        }
        invalidate();
        requestLayout();
    }
}
