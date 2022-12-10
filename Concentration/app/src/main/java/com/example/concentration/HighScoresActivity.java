package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class HighScoresActivity extends AppCompatActivity {

    private Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        getSupportActionBar().setTitle("Concentration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        score = new Score(HighScoresActivity.this);

        Spinner spinnerTiles = findViewById(R.id.mScoreSelect);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this, R.array.dropDown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerTiles.setAdapter(adapter);

        spinnerTiles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

                switch (item) {
                    case "4 tiles": {
                        System.out.println("4 tiles selected.");
                        break;
                    }
                    case "6 tiles": {
                        System.out.println("6 tiles selected.");
                        break;
                    }
                    case "8 tiles": {
                        System.out.println("8 tiles selected.");
                        break;
                    }
                    case "10 tiles": {
                        System.out.println("10 tiles selected.");
                        break;
                    }case "12 tiles": {
                        System.out.println("12 tiles selected.");
                        break;
                    }
                    case "14 tiles": {
                        System.out.println("14 tiles selected.");
                        break;
                    }
                    case "16 tiles": {
                        System.out.println("16 tiles selected.");
                        break;
                    }
                    case "18 tiles": {
                        System.out.println("18 tiles selected.");
                        break;
                    }
                    case "20 tiles": {
                        System.out.println("20 tiles selected.");
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case android.R.id.home:
            {
                Intent parentActivityIntent = new Intent(HighScoresActivity.this, MainActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(parentActivityIntent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}