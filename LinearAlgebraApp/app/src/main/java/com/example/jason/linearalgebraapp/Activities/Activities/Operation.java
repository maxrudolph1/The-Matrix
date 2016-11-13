package com.example.jason.linearalgebraapp.activities.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jason.linearalgebraapp.activities.Fragments.OperationDetailsFragment;
import com.example.jason.linearalgebraapp.R;

/**
 * Created by jason on 11/12/2016.
 */

public class Operation extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

        if (savedInstanceState == null) {

            int index = getIntent().getIntExtra("PLEASE HELP GOD BLESS", -1);

            OperationDetailsFragment detailsFragment = OperationDetailsFragment.newInstance(index);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailsFragmentFrame, detailsFragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
