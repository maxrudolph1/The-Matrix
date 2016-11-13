package com.example.jason.linearalgebraapp.Activities.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.jason.linearalgebraapp.R;

/**
 * Created by jason on 11/12/2016.
 */

public class DotProductFragment extends Fragment {
    private static String KEY_THREAD_INDEX = "thread index key";

    private EditText dotProduct;
    private int selected;
    private LinearLayout vector1;
    private LinearLayout vector2;
    private Spinner rows;

    public static DotProductFragment newInstance(int index) {
        DotProductFragment fragment = new DotProductFragment();

        Bundle arguments = new Bundle();
        arguments.putInt(KEY_THREAD_INDEX, index);

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


        Button b = (Button) rootView.findViewById(R.id.button);
        dotProduct = (EditText) rootView.findViewById(R.id.dotProduct);
        dotProduct.setKeyListener(null);
        vector1 = (LinearLayout) rootView.findViewById(R.id.vector1);
        vector2 = (LinearLayout) rootView.findViewById(R.id.vector2);
        rows = (Spinner) rootView.findViewById(R.id.rows);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rows.setAdapter(adapter);


        rows.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int oldSelected = selected;
                selected = Integer.parseInt((String) adapterView.getItemAtPosition(i));
                if (selected > oldSelected) {
                    for (int index = oldSelected; index < selected; index++) {
                        EditText et = new EditText(getContext());
                        et.setHint("Number");
                        et.setTextColor(Color.BLACK);
                        et.setHintTextColor(Color.BLACK);
                        et.setInputType(InputType.TYPE_CLASS_NUMBER);
                        vector1.addView(et);
                        et = new EditText(getContext());
                        et.setHint("Number");
                        et.setInputType(InputType.TYPE_CLASS_NUMBER);
                        et.setTextColor(Color.BLACK);
                        et.setHintTextColor(Color.BLACK);
                        vector2.addView(et);
                    }
                } else {
                    for (int index = oldSelected - 1; index >= selected; index--) {
                        vector1.removeViewAt(index);
                        vector2.removeViewAt(index);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                int[] v1 = new int[vector1.getChildCount()];
                int[] v2 = new int[vector2.getChildCount()];
                for (int i = 0; i < vector1.getChildCount(); i++) {
                    EditText current = (EditText) vector1.getChildAt(i);
                    EditText current2 = (EditText) vector2.getChildAt(i);
                    try {
                        v1[i] = Integer.parseInt(current.getText().toString());
                        v2[i] = Integer.parseInt(current2.getText().toString());
                    } catch (NumberFormatException e) {
                        return;
                    }
                }
                if (v1.length != v2.length) {
                    return;
                }
                int ans = MatrixOperations.dotProduct(v1, v2);
                dotProduct.setText(String.valueOf(ans));
            }
        });


        return rootView;
    }
}

