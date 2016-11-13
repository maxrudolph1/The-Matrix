package com.example.jason.linearalgebraapp.Activities.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import com.example.jason.linearalgebraapp.R;

/**
 * Created by jason on 11/12/2016.
 */

public class ChooseCalculatorFragment extends Fragment {

    private OnThreadClickedListener threadClickedListener;

    public ChooseCalculatorFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnThreadClickedListener) {
            threadClickedListener = (OnThreadClickedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnThreadClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ListView threadsListView = (ListView) rootView.findViewById(R.id.Calculators);
        setUpList(threadsListView);

        return rootView;
    }

    private void setUpList(ListView threadsListView) {
        String [] threadNames = getResources().getStringArray(R.array.Calculators);

        ListAdapter threadsArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, threadNames);

        threadsListView.setAdapter(threadsArrayAdapter);

        threadsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                threadClickedListener.onThreadClicked(position);
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);
    }
}
