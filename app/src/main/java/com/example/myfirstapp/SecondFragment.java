package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the current count, get the string and format it with the count, and then set it for textview_header.
        Integer count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        String countText = getString(R.string.random_heading, count);
        TextView headerView = binding.textviewHeader;
        headerView.setText(countText);

        // Get a random number between 0 and the count.
        Random random = new java.util.Random();
        Integer randomNumber = 0;
        if (count > 0)
            randomNumber = random.nextInt(count + 1);

        // Convert that number into a string and set it as the text for textview_random
        TextView randomView = binding.textviewRandom;
        randomView.setText(randomNumber.toString());

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}