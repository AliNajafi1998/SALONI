package com.najafi.ali.saloni;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GroupViewTwo3FirstActivity extends ConstraintLayout {

    View rootView;
    TextView tvCost;
    TextView cost;
    TextView currency;
    private String text;

    public GroupViewTwo3FirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewTwo3FirstActivity(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public GroupViewTwo3FirstActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupViewTwo3FirstActivity, defStyleAttr, 0);
        text = ta.getString(R.styleable.GroupViewTwo3FirstActivity_cost_text);
        ta.recycle();
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.group_view_two_3_first_activity, this);
        tvCost = rootView.findViewById(R.id.tv_cost);
        cost = rootView.findViewById(R.id.cost);
        currency = rootView.findViewById(R.id.currency);

        tvCost.setText("هزینه:");
        currency.setText("تومان");
        Typeface typeface = EnglishToPersian.createTypeFace1(context);
        tvCost.setTypeface(typeface);
        cost.setTypeface(typeface);
        currency.setTypeface(typeface);

        text = separator(text);
        cost.setText(EnglishToPersian.englishToPersian(text));


    }

    public String separator(String text) {
        List<String> myNumbers = Arrays.asList(
                NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(text)).split(","));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myNumbers.size(); i++) {
            sb.append(myNumbers.get(i));
            if (i != (myNumbers.size() - 1)) sb.append(",");
        }
        return sb.toString();
    }
    public void setCost(String cost){
        this.text = cost;
        invalidate();
        requestLayout();
    }

    public String getText() {
        return text;
    }
}
