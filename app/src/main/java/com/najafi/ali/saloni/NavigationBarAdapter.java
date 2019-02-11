package com.najafi.ali.saloni;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NavigationBarAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> mnu_ItemsName;
    ArrayList<Integer> mnu_ItemsIcon;

    public NavigationBarAdapter(Context context, ArrayList<String> mnu_ItemsName, ArrayList<Integer> mnu_ItemsIcon) {
        this.context = context;
        this.mnu_ItemsName = mnu_ItemsName;
        this.mnu_ItemsIcon = mnu_ItemsIcon;
    }


    @Override
    public int getCount() {
        return mnu_ItemsIcon.size();
    }

    @Override
    public Object getItem(int position) {
        return mnu_ItemsName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.icon.setImageResource(mnu_ItemsIcon.get(position));
        viewHolder.image_text.setText(mnu_ItemsName.get(position));

        Typeface typeface = EnglishToPersian.createTypeFace1(context);
        viewHolder.image_text.setTypeface(typeface);


        return view;


    }

    class ViewHolder {
        ImageView icon;
        TextView image_text;

        public ViewHolder(View view) {

            this.icon = view.findViewById(R.id.ic_image);
            this.image_text = view.findViewById(R.id.menuText);
        }
    }
}
