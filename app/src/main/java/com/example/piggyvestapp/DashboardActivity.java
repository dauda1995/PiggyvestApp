package com.example.piggyvestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    public static final String PIGGY = "PIGGY";
    public static final String FLEX = "FLEX";
    public static final String TARGET = "TARGET";
    public static final String SAFETY = "SAFELOCK";
    public static final String TAG = "TAG";

    ImageView piggy, safe, target, flex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        piggy = findViewById(R.id.piggy);
        safe = findViewById(R.id.safely);
        target = findViewById(R.id.target);
        flex = findViewById(R.id.flex);

        piggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked(v);
            }
        });

        safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked(v);
            }
        });

        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked(v);
            }
        });

        flex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked(v);
            }
        });

    }

    public void clicked(View v){

        String key = "key";
        Intent intent = new Intent(DashboardActivity.this, CalculatorActivity.class);

        switch (v.getId()){
            case R.id.piggy:
                key = PIGGY;
                Log.d(TAG, "clicked: " + key);
                intent.putExtra("key", key);
                startActivity(intent);
                break;
            case R.id.flex:
                key = FLEX;
                Log.d(TAG, "clicked: " + key);
                intent.putExtra("key", key);
                startActivity(intent);
                break;
            case R.id.safely:
                key = SAFETY;
                Log.d(TAG, "clicked: " + key);
                intent.putExtra("key", key);
                startActivity(intent);
                break;
            case R.id.target:
                key = TARGET;
                Log.d(TAG, "clicked: " + key);
                intent.putExtra("key", key);
                startActivity(intent);
                break;
            default:
                Log.d(TAG, "clicked: " + key);
               break;

        }
    }
}
