package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class GroupViewTwo1FirstActivity extends ConstraintLayout {

    View rootView;
    boolean isDate;
    TextView tvTimeDateUI;
    TextView tvTimeDate;
    String text;

    public GroupViewTwo1FirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewTwo1FirstActivity(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GroupViewTwo1FirstActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupViewTwo1FirstActivity, defStyleAttr, 0);
        isDate = ta.getBoolean(R.styleable.GroupViewTwo1FirstActivity_isDate, false);
        text = ta.getString(R.styleable.GroupViewTwo1FirstActivity_text_time_date);

        ta.recycle();
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.group_view_two_1_first_activity, this);
        tvTimeDate = rootView.findViewById(R.id.tv_time_or_date);
        tvTimeDateUI = rootView.findViewById(R.id.time_from_or_date_txt);
        Typeface typeface = Font.createTypeFaceIransansmobile(context);

        tvTimeDateUI.setTypeface(typeface);
        tvTimeDate.setTypeface(typeface);

        if (isDate) {
            tvTimeDateUI.setText("تاریخ:");
            tvTimeDate.setText(EnglishToPersian.englishToPersian(text));

        } else {
            tvTimeDateUI.setText("زمان:");
            tvTimeDate.setText(text);
        }
    }

    public void isDate(boolean b) {
        this.isDate = b;
        invalidate();
        requestLayout();
    }

    public void setTime(String time) {
        this.text = time;
        invalidate();
        requestLayout();
    }

    public void setDate(String date) {
        this.text = date;
        invalidate();
        requestLayout();

    }
}
