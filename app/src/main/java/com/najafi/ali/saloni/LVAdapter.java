package com.najafi.ali.saloni;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LVAdapter extends BaseAdapter {

    private Context context;
    private List<Complex> complex;

    public LVAdapter(Context context, List<Complex> complex) {
        this.context = context;
        this.complex = complex;
    }

    @Override
    public int getCount() {
        return complex.size();
    }

    @Override
    public Object getItem(int position) {
        return complex.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        LVAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.card_view_recycler_view, parent, false);
            viewHolder = new LVAdapter.ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (LVAdapter.ViewHolder) view.getTag();
        }
        Typeface typeface = Font.createTypeFaceIransansmobile(context);
        viewHolder.textView.setTypeface(typeface);
        viewHolder.hallNo.setTypeface(typeface);
        viewHolder.time_card.setTypeface(typeface);
        viewHolder.tv_time_card.setTypeface(typeface);
        viewHolder.date_txt_card.setTypeface(typeface);
        viewHolder.tv_date_card.setTypeface(typeface);
        viewHolder.time_from_txt_card.setTypeface(typeface);
        viewHolder.tv_start_card.setTypeface(typeface);
        viewHolder.tv_to_card.setTypeface(typeface);
        viewHolder.tv_end_card.setTypeface(typeface);
        viewHolder.tv_cost_card.setTypeface(typeface);
        viewHolder.cost_card.setTypeface(typeface);
        viewHolder.currency.setTypeface(typeface);

        if (complex != null) {
            viewHolder.tv_time_card.setText(complex.get(position).getTime());
            viewHolder.tv_start_card.setText(EnglishToPersian.englishToPersian(complex.get(position).getStartTime()));
            viewHolder.tv_end_card.setText(EnglishToPersian.englishToPersian(complex.get(position).getEndTime()));
            viewHolder.tv_date_card.setText(EnglishToPersian.englishToPersian(complex.get(position).getDate()));
            viewHolder.cost_card.setText(EnglishToPersian.englishToPersian(separator(complex.get(position).getCost())));
            viewHolder.complexName.setText(complex.get(position).getComplexName());
            viewHolder.hallNo.setText(complex.get(position).getComplexNo());


        }

        return view;

    }

    class ViewHolder {
        TextView complexName;
        TextView textView;
        TextView hallNo;
        TextView time_card;
        TextView tv_time_card;
        TextView date_txt_card;
        TextView tv_date_card;
        TextView time_from_txt_card;
        TextView tv_start_card;
        TextView tv_to_card;
        TextView tv_end_card;
        TextView tv_cost_card;
        TextView cost_card;
        TextView currency;


        public ViewHolder(View view) {
            complexName = view.findViewById(R.id.complex_name);
            textView = view.findViewById(R.id.textView);
            hallNo = view.findViewById(R.id.hall_no);
            time_card = view.findViewById(R.id.time_card);
            tv_time_card = view.findViewById(R.id.tv_time_card);
            date_txt_card = view.findViewById(R.id.date_txt_card);
            tv_date_card = view.findViewById(R.id.tv_date_card);//Date
            time_from_txt_card = view.findViewById(R.id.time_from_txt_card);

            tv_start_card = view.findViewById(R.id.tv_start_card);//startTime
            tv_to_card = view.findViewById(R.id.tv_to_card);
            tv_end_card = view.findViewById(R.id.tv_end_card);//endTime
            tv_cost_card = view.findViewById(R.id.tv_cost_card);
            cost_card = view.findViewById(R.id.cost_card);//Money
            currency = view.findViewById(R.id.currency);

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
