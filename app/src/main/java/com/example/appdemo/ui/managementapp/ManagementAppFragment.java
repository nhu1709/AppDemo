package com.example.appdemo.ui.managementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;

import java.util.ArrayList;

public class ManagementAppFragment extends Fragment {

    RecyclerView mAppList;
    AppListAdapter mAdapter;
    GridLayoutManager gridLayoutManager;
    ArrayList<AppListAdapter.model> mIconList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mangement_app, container, false);

        initValue();
        mAppList = root.findViewById(R.id.app_list);
        mAdapter = new AppListAdapter(getActivity(), mIconList, R.layout.item_app_list);
        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        mAppList.setLayoutManager(gridLayoutManager);
        mAppList.setAdapter(mAdapter);
        mAdapter.setItemClicktimePicker(new itemClicktimePicker() {
            @Override
            public void onClick(AppListAdapter.model model) {
                startActivity(new Intent(getActivity(),SettingTimeActivity.class));
            }
        });

        return root;
    }

    public void initValue() {
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_fb, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_skype, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_skype, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_skype, "Facebook", "01:09:23",false,false));
        mIconList.add(new AppListAdapter.model(R.drawable.ic_icon_skype, "Facebook", "01:09:23",false,false));
    }
}
