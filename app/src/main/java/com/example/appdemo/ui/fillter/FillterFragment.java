package com.example.appdemo.ui.fillter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;
import com.example.appdemo.ThemvaodanhsachActivity;
import com.example.appdemo.ui.managementapp.AppListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FillterFragment extends Fragment {
    RecyclerView mData, mDataBlock;
    View mFavoriteListTitle, mBlockListTitle;
    LinearLayout mFavoriteListView, mBlockListView;
    AppListAdapter mAdapterFavorite;
    AppListAdapter mAdapterBlock;
    List<AppListAdapter.model> modelList = new ArrayList<>();
    LinearLayoutManager gridLayoutManager;
    FloatingActionButton floatingActionButton;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fillter, container, false);

        mFavoriteListTitle = root.findViewById(R.id.list_favorite_title);
        mBlockListTitle = root.findViewById(R.id.list_block_title);
        mFavoriteListView = root.findViewById(R.id.list_favorite);
        mBlockListView = root.findViewById(R.id.list_block);
        floatingActionButton = root.findViewById(R.id.floating);

        mFavoriteListTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFavoriteListView.setVisibility(View.VISIBLE);
                mBlockListView.setVisibility(View.GONE);
                mFavoriteListTitle.setBackgroundResource(R.drawable.background_rounded_cornner_selected);
                mBlockListTitle.setBackgroundResource(R.drawable.background_rounded_cornner);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ThemvaodanhsachActivity.class));
            }
        });
        mBlockListTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFavoriteListView.setVisibility(View.GONE);
                mBlockListView.setVisibility(View.VISIBLE);
                mBlockListTitle.setBackgroundResource(R.drawable.background_rounded_cornner_selected);
                mFavoriteListTitle.setBackgroundResource(R.drawable.background_rounded_cornner);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initValueDSC();
        mData = getView().findViewById(R.id.rl_favorite);
        mDataBlock = getView().findViewById(R.id.rl_block);
        mAdapterFavorite = new AppListAdapter(getActivity(),modelList,R.layout.i_tv);
        gridLayoutManager = new LinearLayoutManager(getContext());
        mData.setLayoutManager(gridLayoutManager);
        mData.setAdapter(mAdapterFavorite);


        mDataBlock = getView().findViewById(R.id.rl_block);
        mAdapterBlock = new AppListAdapter(getActivity(),modelList,R.layout.i_tv);
        gridLayoutManager = new LinearLayoutManager(getContext());
        mDataBlock.setLayoutManager(gridLayoutManager);
        mDataBlock.setAdapter(mAdapterFavorite);
    }

    private void initValueDSC() {
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",false,false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_gg_plus,"Facebook","01:09:23",false,false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_skype,"Facebook","01:09:23",false,true));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_instagram,"Facebook","01:09:23",false,false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_messenger,"Facebook","01:09:23",false,false));
        modelList.add(new AppListAdapter.model(R.drawable.ic_icon_fb,"Facebook","01:09:23",false,false));
    }
}