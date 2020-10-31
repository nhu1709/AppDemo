package com.example.appdemo.ui.fillter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;

public class FillterFragment extends Fragment {

    View mFavoriteListTitle, mBlockListTitle;
    LinearLayout mFavoriteListView, mBlockListView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fillter, container, false);

        mFavoriteListTitle = root.findViewById(R.id.list_favorite_title);
        mBlockListTitle = root.findViewById(R.id.list_block_title);
        mFavoriteListView = root.findViewById(R.id.list_favorite);
        mBlockListView = root.findViewById(R.id.list_block);

        mFavoriteListTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFavoriteListView.setVisibility(View.VISIBLE);
                mBlockListView.setVisibility(View.GONE);
                mFavoriteListTitle.setBackgroundResource(R.drawable.background_rounded_cornner_selected);
                mBlockListTitle.setBackgroundResource(R.drawable.background_rounded_cornner);
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
}