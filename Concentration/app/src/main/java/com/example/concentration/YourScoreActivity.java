package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class YourScoreActivity extends AppCompatActivity {

    private Button backToMainMenu;
    private Score score;
    TextView tv1;
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_score);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        score = new Score(YourScoreActivity.this);

        tv1 = (TextView)findViewById(R.id.yourScoreDisplay);
        tv1.setText("Score: "+GameActivity.newScore.getScore());

        backToMainMenu = findViewById(R.id.mMainMenu);
        backToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.resetScores();
                nameInput = (EditText) findViewById(R.id.editTextTextPersonName);
                String name = nameInput.getText().toString();

                GameActivity.newScore.setName(name);
                score.addScore(GameActivity.gameNum, GameActivity.newScore);

                Intent parentActivityIntent = new Intent(YourScoreActivity.this, MainActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(parentActivityIntent);
                finish();
            }
        });
    }
}