package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class TimeGroupView extends ConstraintLayout {

    View rootView;
    TextView start;
    TextView to;
    TextView end;
    TextView time;
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

        start.setTypeface(Font.createTypeFaceIransansmobileLight(context));
        to.setTypeface(Font.createTypeFaceIransansmobileLight(context));
        end.setTypeface(Font.createTypeFaceIransansmobileLight(context));
        time.setTypeface(Font.createTypeFaceIransansmobileLight(context));

        start.setText(EnglishToPersian.englishToPersian(startTimeText));
        end.setText(EnglishToPersian.englishToPersian(endTimeText));
        time.setText(timeText);
    }
}
