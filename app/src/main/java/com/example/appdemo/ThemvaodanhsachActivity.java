package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appdemo.ui.managementapp.AppListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThemvaodanhsachActivity extends AppCompatActivity {
    List<AppListAdapter.model> modelList = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager gridLayoutManager;
    AppListAdapter mAdapterFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValueDSC();
        setContentView(R.layout.activity_themvaodanhsach);
        recyclerView = findViewById(R.id.rl_themvao);
        mAdapterFavorite = new AppListAdapter(this,modelList,R.layout.item_add);
        gridLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mAdapterFavorite);
    }

    private void initValueDSC() {
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus,"Facebook","01:09:23",false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_skype,"Facebook","01:09:23",false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_instagram,"Facebook","01:09:23",false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_messenger,"Facebook","01:09:23",false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",false));
    }
}