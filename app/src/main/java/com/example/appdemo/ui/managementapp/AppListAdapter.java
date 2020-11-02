package com.example.appdemo.ui.managementapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppListViewHolder> {

    Context mContext;
    List<model> list;
    interfac interfac;
    itemClicktimePicker itemClicktimePicker;
    @LayoutRes
    int resId;
    ArrayList<Integer> mIconList = new ArrayList<>();
    ArrayList<String> mTitleAppList = new ArrayList<>();
    ArrayList<String> mTimeUsedAppList = new ArrayList<>();
    onClickdscd onClickdscd;


    public AppListAdapter(Context mContext, List<model> list, int resId) {
        this.mContext = mContext;
        this.list = list;
        this.resId = resId;
    }

    public void setItemClicktimePicker(com.example.appdemo.ui.managementapp.itemClicktimePicker itemClicktimePicker) {
        this.itemClicktimePicker = itemClicktimePicker;
    }

    public void setInterfac(com.example.appdemo.ui.managementapp.interfac interfac) {
        this.interfac = interfac;
    }

    public void setOnClickdscd(AppListAdapter.onClickdscd onClickdscd) {
        this.onClickdscd = onClickdscd;
    }

    @NonNull
    @Override
    public AppListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View appListView = inflater.inflate(resId, parent, false);
        return new AppListViewHolder(appListView);
    }

    @Override
    public void onBindViewHolder(@NonNull AppListViewHolder holder, final int i) {
        holder.bindView(list.get(i));
        if (interfac != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    submit(i);
                }
            });
            return;
        }

        if (itemClicktimePicker != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClicktimePicker != null) itemClicktimePicker.onClick(list.get(i));
                }
            });
            return;
        }

        if (onClickdscd != null) {
            holder.imgCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickdscd != null) onClickdscd.onclick(list.get(i));
                }
            });
            holder.imgCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickdscd != null){
                        Toast.makeText(mContext, "Biến khỏi cuộc đời tao", Toast.LENGTH_SHORT).show();
                        list.remove(list.get(i));
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private void submit(int i) {
        if (interfac != null) {
            removeCheckAndCheck(list.get(i));
        }
    }

    private void removeCheckAndCheck(model model) {
        for (model m : list) {
            m.setCheck(false);
        }
        model.setCheck(true);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AppListViewHolder extends RecyclerView.ViewHolder {

        ImageView mIconApp;
        ImageView imgCheck , imgCancel;
        TextView mTitleApp, mTimeUsedApp;

        public AppListViewHolder(@NonNull View itemView) {
            super(itemView);
            mIconApp = itemView.findViewById(R.id.icon_app);
            imgCheck = itemView.findViewById(R.id.checked);
            imgCancel = itemView.findViewById(R.id.img_cancel);
            mTitleApp = itemView.findViewById(R.id.title_app);
            mTimeUsedApp = itemView.findViewById(R.id.time_used_app);
            mTimeUsedApp = itemView.findViewById(R.id.time_used_app);
        }

        public void bindView(model model) {
            mIconApp.setImageResource(model.getImg());
            mTitleApp.setText(model.getTitle());
            mTimeUsedApp.setText(model.getTime());
            imgCheck.setVisibility(model.isCheck() ? View.VISIBLE : View.GONE);

        }
    }

    public void setList(List<model> list) {
        this.list = list;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class model {
        private int img;
        private String title;
        private String time;
        private boolean check;

        public model(int img, String title, String time) {
            this.img = img;
            this.title = title;
            this.time = time;
        }
    }

   public interface onClickdscd {
        void onclick(model model);
        void onclickRM(model model);
    }

}
