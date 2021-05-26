package com.example.android162.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android162.R;
import com.example.android162.databinding.FragmentCheckBinding;
import com.example.android162.databinding.FragmentDraftBinding;

public class DraftFragment extends Fragment {

    private FragmentDraftBinding binding;
    private FragmentManager fm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDraftBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}