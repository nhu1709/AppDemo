package com.example.appdemo.ui.managementapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;

import java.util.ArrayList;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppListViewHolder> {

    Context mContext;
    ArrayList<Integer> mIconList = new ArrayList<>();
    ArrayList<String> mTitleAppList = new ArrayList<>();
    ArrayList<String> mTimeUsedAppList = new ArrayList<>();

    public AppListAdapter(Context context) {
        mContext = context;
    }

    public void updateAppView(ArrayList<Integer> listIcon, ArrayList<String> listTitleApp, ArrayList<String> listTimeUsed) {
        mIconList = listIcon;
        mTitleAppList = listTitleApp;
        mTimeUsedAppList = listTimeUsed;
    }

    @NonNull
    @Override
    public AppListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View appListView = inflater.inflate(R.layout.item_app_list, parent, false);
        return new AppListViewHolder(appListView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppListViewHolder holder, int position) {
        holder.bindView(mIconList.get(position), mTitleAppList.get(position), mTimeUsedAppList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitleAppList.size();
    }


    class AppListViewHolder extends RecyclerView.ViewHolder {

        ImageView mIconApp;
        TextView mTitleApp, mTimeUsedApp;

        public AppListViewHolder(@NonNull View itemView) {
            super(itemView);

            mIconApp = itemView.findViewById(R.id.icon_app);
            mTitleApp = itemView.findViewById(R.id.title_app);
            mTimeUsedApp = itemView.findViewById(R.id.time_used_app);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //mContext.startActivities(new Intent(mContext, SettingTimeActivity.class));
                }
            });
        }

        public void bindView(int iconApp, String titleApp, String timedUsedApp) {
            mIconApp.setImageResource(iconApp);
            mTitleApp.setText(titleApp);
            mTimeUsedApp.setText(timedUsedApp);
        }
    }
}
