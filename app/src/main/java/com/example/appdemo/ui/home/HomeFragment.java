package com.example.appdemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;
import com.example.appdemo.ui.managementapp.AppListAdapter;
import com.example.appdemo.ui.managementapp.interfac;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment implements interfac {
    RecyclerView mData;
    RecyclerView mListDSC;
    AppListAdapter mAdapter, adtDanhsachcho;
    LinearLayoutManager gridLayoutManager;
    ArrayList<AppListAdapter.model> mIconList = new ArrayList<>();
    ArrayList<AppListAdapter.model> mIconListdsc = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initValue();
        initValueDSC();
        mData = Objects.requireNonNull(getView()).findViewById(R.id.listData);
        mListDSC = Objects.requireNonNull(getView()).findViewById(R.id.listDanhsachcho);
        adtDanhsachcho = new AppListAdapter(getContext(),mIconListdsc,R.layout.i_dscd);
        mAdapter = new AppListAdapter(getActivity(),mIconList,R.layout.i_tv);

        gridLayoutManager = new LinearLayoutManager(getContext());
        mData.setLayoutManager(gridLayoutManager);
        mData.setAdapter(mAdapter);
        mListDSC.setAdapter(adtDanhsachcho);
        adtDanhsachcho.setOnClickdscd(new AppListAdapter.onClickdscd() {
            @Override
            public void onclick(AppListAdapter.model model) {
                Toast.makeText(getActivity(), "OK babe", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onclickRM(AppListAdapter.model model) {

            }
        });
        mAdapter.setInterfac(this);
    }

    private void initValueDSC() {
        mIconListdsc.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",true));
        mIconListdsc.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus,"Facebook","01:09:23",true));
        mIconListdsc.add(new AppListAdapter.model(R.drawable.ic_icon_skype,"Facebook","01:09:23",true));
        mIconListdsc.add(new AppListAdapter.model(R.drawable.ic_icon_instagram,"Facebook","01:09:23",true));
        mIconListdsc.add(new AppListAdapter.model(R.drawable.ic_icon_messenger,"Facebook","01:09:23",true));
        mIconListdsc.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",true));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    @Override
    public void onClick(AppListAdapter.model model) {

    }

    private void initValue() {
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus,"Facebook","01:09:23",false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_skype,"Facebook","01:09:23",false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_instagram,"Facebook","01:09:23",false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_messenger,"Facebook","01:09:23",false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",false));
    }
}