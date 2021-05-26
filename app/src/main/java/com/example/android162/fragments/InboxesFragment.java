package com.example.android162.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android162.databinding.FragmentInboxesBinding;

public class InboxesFragment extends Fragment {

    private FragmentInboxesBinding binding;
    private FragmentManager fm;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInboxesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}