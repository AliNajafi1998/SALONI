package com.najafi.ali.saloni;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GroupViewOne2FirstActivity extends LinearLayout {

    View rootView;
    TextView textView;

    public GroupViewOne2FirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewOne2FirstActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GroupViewOne2FirstActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public GroupViewOne2FirstActivity(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

        rootView = inflate(context, R.layout.group_view_one_2_first_activity, this);

        textView = rootView.findViewById(R.id.tv_help);
        textView.setTypeface(Font.createTypeFaceIransansmobile(context));
    }
}
