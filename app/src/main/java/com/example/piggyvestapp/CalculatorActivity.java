package com.example.piggyvestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    EditText principaled, interested, perioded;
    Button calculate, reset;
    TextView year_txt, day_txt, caption_txt;
    String cat = "";
    int interest = 0;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        String category = getIntent().getStringExtra("key");
        Log.d(TAG, "clicked: intent " + category);
        String[] categories = {DashboardActivity.PIGGY, DashboardActivity.FLEX, DashboardActivity.SAFETY, DashboardActivity.TARGET};
        int[] plan = {10, 10, 13, 10};
        Log.d(TAG, "onCreate: just tot check" + DashboardActivity.TARGET);

        for( int i = 0; i < categories.length; i++){
            if(category.equals(categories[i])){
                Log.d(TAG, "onCreate: " + categories[i]);
                Log.d(TAG, "onCreate: " + plan[i]);
                cat = categories[i];
                interest = plan[i];
                break;

            }
        }

        Log.d(TAG, "onCreate: gets" + plan + " " + cat);

        caption_txt = findViewById(R.id.caption);
        caption_txt.setText(cat + " INTEREST CALCULATOR");
        principaled = findViewById(R.id.principal);
//        interested = findViewById(R.id.rate_of_interest);
        perioded = findViewById(R.id.period_edit);
        calculate = findViewById(R.id.calculate);
        reset = findViewById(R.id.reset);
        year_txt = findViewById(R.id.interest_year);
        day_txt = findViewById(R.id.interest_day);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onCreate: " );
                calculateInterest();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principaled.setText(null);
                interested.setText(null);
                perioded.setText(null);
                year_txt.setText(null);
                day_txt.setText(null);
            }
        });

    }



    public void calculateInterest() {
        Log.d(TAG, "onCreate: calculate the iterest");
        if(((principaled.getText().toString()).equals("") && (perioded.getText().toString()).equals(""))){
            return;
        }


            Double principal = Double.parseDouble(principaled.getText().toString());
            Double period = Double.parseDouble(perioded.getText().toString());
            Double result = 0.0;
            Double result_day = 0.0;

            result = (principal * interest * period) / 100;
            result_day =(result/(12*30));

            year_txt.setText("YOUR " + cat +" PLAN INTEREST FOR A YEAR IS N" + (result.shortValue()));
            day_txt.setText("YOUR " + cat + " PLAN INTEREST FOR A DAY IS N" + result_day.toString());

        }


}
