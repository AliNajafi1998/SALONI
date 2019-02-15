package com.najafi.ali.saloni;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PackageAdapter extends BaseAdapter {

    private Context context;
    private List<PackageDetails> list;

    public PackageAdapter(Context context, List<PackageDetails> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        PackageAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.items_of_package_list_view, parent, false);
            viewHolder = new PackageAdapter.ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (PackageAdapter.ViewHolder) view.getTag();
        }

        viewHolder.cost.setTypeface(Font.createTypeFaceIransansmobileBold(context));
        viewHolder.currency.setTypeface(Font.createTypeFaceIransansmobileBold(context));
        viewHolder.packageName.setTypeface(Font.createTypeFaceIransansmobile(context));
        viewHolder.condition1.setTypeface(Font.createTypeFaceIransansmobile(context));
        viewHolder.condition2.setTypeface(Font.createTypeFaceIransansmobile(context));

        viewHolder.constraintLayout.setBackground(context.getResources().getDrawable(list.get(position).getBg()));
        viewHolder.packageName.setText(list.get(position).getName());
        viewHolder.cost.setText(EnglishToPersian.englishToPersian(separator(list.get(position).getCost())));

        return view;


    }

    class ViewHolder {
        ConstraintLayout constraintLayout;
        TextView packageName;
        TextView currency;
        TextView cost;
        TextView condition1;
        TextView condition2;

        public ViewHolder(View view) {

            this.constraintLayout = view.findViewById(R.id.itemsbg);
            this.packageName = view.findViewById(R.id.package_name);
            this.currency = view.findViewById(R.id.currency2);
            this.cost = view.findViewById(R.id.cost2);
            this.condition1 = view.findViewById(R.id.condition1);
            this.condition2 = view.findViewById(R.id.condition2);
        }
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
}

