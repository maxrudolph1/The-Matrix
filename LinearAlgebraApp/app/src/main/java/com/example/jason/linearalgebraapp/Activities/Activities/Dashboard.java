package com.example.jason.linearalgebraapp.Activities.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jason.linearalgebraapp.Activities.Fragments.OnThreadClickedListener;
import com.example.jason.linearalgebraapp.R;

public class Dashboard extends AppCompatActivity implements OnThreadClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }



    private void startThreadDetailsActivity(int index) {
        Intent intent = new Intent(this, Operation.class);

        intent.putExtra("PLEASE HELP GOD BLESS", index);

        startActivity(intent);
    }

    @Override
    public void onThreadClicked(int index) {
        startThreadDetailsActivity(index);
    }
}
