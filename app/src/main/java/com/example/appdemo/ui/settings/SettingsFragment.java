package com.example.appdemo.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.appdemo.R;
import com.example.appdemo.ui.settings.activity.AccountAcitivity;
import com.example.appdemo.ui.settings.activity.BlockAppAcitivity;
import com.example.appdemo.ui.settings.activity.DeviceConnectedActivity;
import com.example.appdemo.ui.settings.activity.NotificationAcitivity;

public class SettingsFragment extends Fragment {

    View mDeviceConnectedSetting, mNotificationSetting, mAccountSetting, mBlockAppSetting, mLogout;
    FragmentManager mFragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        mFragmentManager = getActivity().getSupportFragmentManager();

        initView(root);

        mDeviceConnectedSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), DeviceConnectedActivity.class));
            }
        });
        mNotificationSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), NotificationAcitivity.class));
            }
        });
        mAccountSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), AccountAcitivity.class));
            }
        });
        mBlockAppSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), BlockAppAcitivity.class));
            }
        });
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return root;
    }

    public void initView(View view) {
        mDeviceConnectedSetting = view.findViewById(R.id.device_connected_setting);
        mNotificationSetting = view.findViewById(R.id.notification_setting);
        mAccountSetting = view.findViewById(R.id.account_setting);
        mBlockAppSetting = view.findViewById(R.id.block_app_setting);
        mLogout = view.findViewById(R.id.logout);
    }
}
