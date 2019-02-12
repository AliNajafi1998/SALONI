package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class GroupViewTwo4FirstActivity extends ConstraintLayout {

    View rootView;
    TextView sportComplexName;
    TextView hallNumber;
    TextView number;
    String txtNo;
    String complexName;
    public GroupViewTwo4FirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewTwo4FirstActivity(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public GroupViewTwo4FirstActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupViewTwo4FirstActivity, defStyleAttr, 0);
        txtNo = ta.getString(R.styleable.GroupViewTwo4FirstActivity_hallNo);
        complexName = ta.getString(R.styleable.GroupViewTwo4FirstActivity_complex_name);
        ta.recycle();
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.group_view_two_4_first_activity, this);
        Typeface typeface = EnglishToPersian.createTypeFace1(context);
        sportComplexName = rootView.findViewById(R.id.sport_complex_name);
        hallNumber = rootView.findViewById(R.id.hallNumber);
        number = rootView.findViewById(R.id.number);
        sportComplexName.setTypeface(typeface);
        hallNumber.setTypeface(typeface);
        number.setTypeface(typeface);

        number.setText(EnglishToPersian.englishToPersian(txtNo));
        hallNumber.setText("سالن شماره ");
        sportComplexName.setText("مجتمع ورزشی افق لاله");

    }

}
