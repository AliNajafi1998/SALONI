package com.najafi.ali.saloni;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> spinnerList;

    public SpinnerAdapter(Context context, ArrayList<String> spinnerList) {
        this.context = context;
        this.spinnerList = spinnerList;
    }

    @Override
    public int getCount() {
        return spinnerList.size();
    }

    @Override
    public Object getItem(int position) {
        return spinnerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        SpinnerAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
            viewHolder = new SpinnerAdapter.ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (SpinnerAdapter.ViewHolder) view.getTag();
        }


            viewHolder.textView.setTypeface(Font.createTypeFaceIransansmobile(context));
            viewHolder.textView.setText(spinnerList.get(position));

        return view;

    }

    class ViewHolder {

        TextView textView;

        public ViewHolder(View view) {
            textView = view.findViewById(R.id.spinnerText);
        }
    }
}
