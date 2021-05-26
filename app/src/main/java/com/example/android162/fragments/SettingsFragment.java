package com.example.android162.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android162.R;
import com.example.android162.databinding.FragmentSendBinding;

public class SettingsFragment extends Fragment {

    private FragmentSendBinding binding;
    private FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSendBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}