package com.najafi.ali.saloni;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class GroupViewOneFirstActivity extends CardView {

    View rootView;
    ImageView imgPhone;
    EditText txtPhoneNumber;
    int iconId;
    int maxLength = 11;
    String hint;
    int txt_size;

    public GroupViewOneFirstActivity(Context context) {
        super(context);
        init(context);
    }

    public GroupViewOneFirstActivity(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GroupViewOneFirstActivity(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.GroupViewOneFirstActivity,defStyleAttr,0);

        iconId = ta.getResourceId(R.styleable.GroupViewOneFirstActivity_src_icon,0);
        maxLength = ta.getInt(R.styleable.GroupViewOneFirstActivity_max_length,11);
        hint = ta.getString(R.styleable.GroupViewOneFirstActivity_hint);
        txt_size = ta.getInt(R.styleable.GroupViewOneFirstActivity_txt_size,16);

        ta.recycle();

        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.group_view_one_first_activity, this);
        imgPhone = rootView.findViewById(R.id.img_icon);
        txtPhoneNumber = rootView.findViewById(R.id.txt_view);
        txtPhoneNumber.setTypeface(EnglishToPersian.createTypeFace(context));

        imgPhone.setImageResource(iconId);
        txtPhoneNumber.setHint(hint);
        txtPhoneNumber.setEms(maxLength);
        txtPhoneNumber. setTextSize(TypedValue.COMPLEX_UNIT_SP, txt_size);
    }

}
