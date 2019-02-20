package com.najafi.ali.saloni;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopeer.shadow.ShadowView;

public class ClockTimeFragment extends Fragment implements View.OnClickListener {
    GroupViewClockTime groupViewClockTime1;
    GroupViewClockTime groupViewClockTime2;
    ShadowView cardVew1;
    ShadowView cardVew2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.times_of_sallons_item_fragment, container, false);
        groupViewClockTime1 = rootView.findViewById(R.id.grp_time_1);
        groupViewClockTime2 = rootView.findViewById(R.id.grp_time_2);
        cardVew1 = rootView.findViewById(R.id.cardView2_1);
        cardVew2 = rootView.findViewById(R.id.cardView2_2);

        groupViewClockTime1.setOnClickListener(this);
        groupViewClockTime2.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.grp_time_1:
                groupViewClockTime1.changeColor(true, getActivity());
                groupViewClockTime2.changeColor(false, getActivity());
                cardVew1.setShadowColor(Color.parseColor("#51af57"));
                cardVew2.setShadowColor(Color.parseColor("#747474"));
                break;
            case R.id.grp_time_2:
                groupViewClockTime1.changeColor(false, getActivity());
                groupViewClockTime2.changeColor(true, getActivity());
                cardVew1.setShadowColor(Color.parseColor("#747474"));
                cardVew2.setShadowColor(Color.parseColor("#51af57"));
                break;

        }
    }
}
