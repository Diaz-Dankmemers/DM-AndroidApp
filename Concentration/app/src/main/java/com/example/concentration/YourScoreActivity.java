package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YourScoreActivity extends AppCompatActivity {

    private Button backToMainMenu;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_score);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        tv1 = (TextView)findViewById(R.id.yourScoreDisplay);
        tv1.setText("Score: "+GameActivity.newScore.getScore());

        backToMainMenu = findViewById(R.id.mMainMenu);
        backToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parentActivityIntent = new Intent(YourScoreActivity.this, MainActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(parentActivityIntent);
                finish();
            }
        });
    }
}