package com.example.jason.linearalgebraapp.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import com.example.jason.linearalgebraapp.activities.Fragments.OnThreadClickedListener;
import com.example.jason.linearalgebraapp.R;

public class Dashboard extends AppCompatActivity implements OnThreadClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }



    private void startThreadDetailsActivity(int index) {
        Intent intent = new Intent(this, Operation.class);

        intent.putExtra("PLEASE HELP GOD BLESS", index);

//        PendingIntent pendingIntent = TaskStackBuilder.create(this)
//                        // add all of DetailsActivity's parents to the stack,
//                        // followed by DetailsActivity itself
//                .addNextIntentWithParentStack(intent)
//                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        startActivity(intent);
    }

    @Override
    public void onThreadClicked(int index) {
        startThreadDetailsActivity(index);
    }
}
