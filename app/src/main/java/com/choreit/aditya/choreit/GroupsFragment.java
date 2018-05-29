package com.choreit.aditya.choreit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class GroupsFragment extends Fragment {
    private static final String TAG = "GroupsFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.groups_fragment, container, false);
        FloatingActionButton groups_fab = (FloatingActionButton) view.findViewById(R.id.groups_fab);
        groups_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Floating button works in groups!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}