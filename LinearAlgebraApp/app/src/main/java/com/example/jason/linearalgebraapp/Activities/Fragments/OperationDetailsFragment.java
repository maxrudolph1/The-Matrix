package com.example.jason.linearalgebraapp.Activities.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by jason on 11/13/2016.
 */


import com.example.jason.linearalgebraapp.R;


public class OperationDetailsFragment extends Fragment {
    private static String OPERATION_INDEX = "OPERATION INDEX KEY";

    private int index;

    public static OperationDetailsFragment newInstance(int index) {
        OperationDetailsFragment fragment = new OperationDetailsFragment();

        Bundle arguments = new Bundle();
        arguments.putInt(OPERATION_INDEX, index);

        fragment.setArguments(arguments);

        return fragment;
    }

    public OperationDetailsFragment() {}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(OPERATION_INDEX)) {
            setCalculator(getArguments().getInt(OPERATION_INDEX));

        } else {
            displayNoCalculator();
        }
    }

    private void displayNoCalculator() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_operations, container, false);
        return rootView;
    }

    private void setCalculator(int index) {
        Fragment newFragment = new DefaultFragment();
        FragmentManager transaction = getActivity().getSupportFragmentManager();

        if (index == 0) {
            newFragment = new DotProductFragment();
        }
        else if (index == 1) {
            newFragment = new MatrixMultiplicationFragment();
        }
        transaction.beginTransaction()
                .replace(R.id.detailsFragmentFrame, newFragment)
                .addToBackStack(null)
                .commit();

    }
}
