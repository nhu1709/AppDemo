package com.example.appdemo.ui.statistical;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;
import com.example.appdemo.ui.managementapp.AppListAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticalFragment extends Fragment {
    RecyclerView mAppList;
    AppListAdapter mAdapter;
    LinearLayoutManager gridLayoutManager;
    ArrayList<AppListAdapter.model> mIconList = new ArrayList<>();

    private BarChart mChart;
    private ImageView mIconFb, mIconMes, mIconViber, mIconIns;
    private TextView mTitle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_statistical, container, false);

        mChart = root.findViewById(R.id.chart1);
        mIconFb = root.findViewById(R.id.icon_fb);
        mIconMes = root.findViewById(R.id.icon_messenger);
        mIconViber = root.findViewById(R.id.icon_viber);
        mIconIns = root.findViewById(R.id.icon_instagram);
        mTitle = root.findViewById(R.id.title_app_current);

        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setPinchZoom(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getLegend().setEnabled(false);


        bindChart(7, 5.5f, 6);
        mTitle.setText("Facebook");

        mIconFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindChart(7, 5.5f, 6);
                mTitle.setText("Facebook");
            }
        });

        mIconViber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindChart(3, 4.5f, 8);
                mTitle.setText("Viber");
            }
        });

        mIconIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindChart(4, 6.5f, 4.5f);
                mTitle.setText("Instagram");
            }
        });

        mIconMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindChart(7, 5, 3);
                mTitle.setText("Messenger");
            }
        });

        return root;
    }

    private void bindChart(float time1, float time2, float time3) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, time1));
        entries.add(new BarEntry(2, time2));
        entries.add(new BarEntry(3, time3));

        BarDataSet dataSet = new BarDataSet(entries, "time");

        BarData data = new BarData(dataSet);
        mChart.setData(data);

        dataSet.setColors(Color.parseColor("#2EFEF7"));
        mChart.animateY(1000);
        mChart.invalidate();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initValue();
        mAppList = getView().findViewById(R.id.app_list);
        mAdapter = new AppListAdapter(getActivity(), mIconList, R.layout.item_lietke);
        mAppList.setAdapter(mAdapter);
    }

    private void initValue() {
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_fb, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus, "Facebook", "01:09:23",false,false));
    }
}