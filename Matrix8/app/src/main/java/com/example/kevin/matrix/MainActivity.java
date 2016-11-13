package com.example.kevin.matrix;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button b = (Button) findViewById(R.id.button);
        final EditText dotProduct = (EditText) findViewById(R.id.dotProduct);
        dotProduct.setKeyListener(null);
        final LinearLayout vector1 = (LinearLayout) findViewById(R.id.vector1);
        final LinearLayout vector2 = (LinearLayout) findViewById(R.id.vector2);
        final Spinner rows = (Spinner) findViewById(R.id.rows);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
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
                        EditText et = new EditText(getApplicationContext());
                        et.setHint("Number");
                        et.setTextColor(Color.BLACK);
                        et.setHintTextColor(Color.BLACK);
                        et.setInputType(InputType.TYPE_CLASS_NUMBER);
                        vector1.addView(et);
                        et = new EditText(getApplicationContext());
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
                for (int i = 0; i < vector1.getChildCount(); i++) {
                    EditText current = (EditText) vector1.getChildAt(i);
                    EditText current2 = (EditText) vector2.getChildAt(i);

                    int number1;
                    int number2;
                    try {
                        number1 = Integer.parseInt(current.getText().toString());
                        number2 = Integer.parseInt(current2.getText().toString());
                    } catch (NumberFormatException e) {
                        return;
                    }
                    sum += number1 * number2;
                }
                dotProduct.setText(String.valueOf(sum));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
