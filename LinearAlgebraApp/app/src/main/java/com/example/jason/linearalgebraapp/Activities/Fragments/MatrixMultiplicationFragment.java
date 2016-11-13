package com.example.jason.linearalgebraapp.activities.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason.linearalgebraapp.R;

/**
 * Created by jason on 11/13/2016.
 */

public class MatrixMultiplicationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_matrixmultiplication, container, false);
        return rootView;
    }

    public MatrixMultiplicationFragment() {}

}
