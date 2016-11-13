package com.example.jason.linearalgebraapp.Activities.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jason.linearalgebraapp.R;

/**
 * Created by jason on 11/12/2016.
 */

public class DotProductFragment extends Fragment {
    private static String KEY_THREAD_INDEX = "thread index key";

    private TextView descriptionTextView;
    private TextView titleTextView;

    public static DotProductFragment newInstance(int threadIndex) {
        DotProductFragment fragment = new DotProductFragment();

        Bundle arguments = new Bundle();
        arguments.putInt(KEY_THREAD_INDEX, threadIndex);

        fragment.setArguments(arguments);

        return fragment;
    }

    public DotProductFragment() {
        /*
         * All fragments must have an empty public constructor so the
         * Android OS can create them without having to pass the fragment's
         * constructor any parameters. If you need to pass your fragment any
         * arguments, see the usage of Fragment#setArguments(Bundle) above.
         */
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dotproduct, container, false);

//        titleTextView = (TextView) rootView.findViewById(R.id.threadNameTextView);
//        descriptionTextView = (TextView) rootView.findViewById(R.id.threadDescriptionTextView);

        return rootView;
    }
}

