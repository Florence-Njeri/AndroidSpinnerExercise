package com.example.android.andoidspinnerexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        /*Create an ArrayAdapter using the string array and a default spinner layout for each item
        R.array.countries_array finds the array in the strings resources via the name assigned to the array list
        android.R.layout.simple_spinner_item is an inbuilt resource
         */
        adapter = ArrayAdapter.createFromResource(this, R.array.countries_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears(dropdown)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // AdapterView.OnItemSelectedListener() is an
        // Interface definition for a callback to be invoked when an item in this view has been selected.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //onItemSelected() and onNothingSelected() are callback methods.

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                textView = (TextView) findViewById(R.id.text_view);
                spinner.setOnItemSelectedListener(this);
                //GEts the selected item from the spinner and displays it in the textView

            }
            // invoked when the selection disappears from this view
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onClick(View view) {

//Set the textView to the selected item on the list
        textView.setText(spinner.getSelectedItem().toString());

    }

}

