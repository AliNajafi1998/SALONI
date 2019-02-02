package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class GroupViewTwo1FirstActivity  extends ConstraintLayout {

    TextView tvTime;
    TextView timeTv;
    View rootView;
    String text;
    public GroupViewTwo1FirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewTwo1FirstActivity(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GroupViewTwo1FirstActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.GroupViewTwo1FirstActivity,defStyleAttr,0);
        text = ta.getString(R.styleable.GroupViewTwo1FirstActivity_text_time);
        ta.recycle();
        init(context);
    }



    private void init(Context context) {
        rootView = inflate(context,R.layout.group_view_two_1_first_activity,this);

        tvTime = rootView.findViewById(R.id.tv_time);
        timeTv = rootView.findViewById(R.id.time_txt);
        tvTime.setText(text);
        tvTime.setTypeface(EnglishToPersian.createTypeFace(context));
        timeTv.setTypeface(EnglishToPersian.createTypeFace(context));

    }
}
