package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class GroupViewDiscount extends ConstraintLayout {
    View rootView;
    TextView salon_txt;
    TextView salon_no;
    TextView rating_no;
    RatingBar ratingBar;
    String salonNo;
    String ratingNo;

    public GroupViewDiscount(Context context) {
        super(context);
        init(context);
    }

    public GroupViewDiscount(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GroupViewDiscount(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupViewDiscount, defStyleAttr, 0);
        salonNo = ta.getString(R.styleable.GroupViewDiscount_salon_no);
        ratingNo = ta.getString(R.styleable.GroupViewDiscount_rate);
        ta.recycle();
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.group_view_discount, this);
        salon_txt = rootView.findViewById(R.id.salon_txt);
        salon_no = rootView.findViewById(R.id.salon_no);
        rating_no = rootView.findViewById(R.id.rating_num);
        ratingBar = rootView.findViewById(R.id.ratingBar);

        salon_no.setTypeface(Font.createTypeFaceIransansmobileMedium(context));
        salon_txt.setTypeface(Font.createTypeFaceIransansmobileMedium(context));
        rating_no.setTypeface(Font.createTypeFaceIransansmobile(context));

        salon_no.setText(salonNo);
        ratingBar.setRating(Float.valueOf(ratingNo));
        rating_no.setText(EnglishToPersian.englishToPersian(ratingNo));
    }
}
