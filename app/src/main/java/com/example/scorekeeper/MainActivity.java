package com.example.scorekeeper;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goalTeamA(View view) {
        scoreTeamA += 1;
        displayScoreTeamA(scoreTeamA);
        getPoints(scoreTeamA, scoreTeamB);
    }

    public void goalTeamB(View view) {
        scoreTeamB += 1;
        displayScoreTeamB(scoreTeamB);
        getPoints(scoreTeamA, scoreTeamB);
    }

    private void displayScoreTeamA(int scoreTeamA){
        TextView textView = findViewById(R.id.score_FCB);
        textView.setText(String.valueOf(scoreTeamA));
    }

    private void displayScoreTeamB(int scoreTeamB){
        TextView textView = findViewById(R.id.score_RM);
        textView.setText(String.valueOf(scoreTeamB));
    }

    private void getPoints(int scoreTeamA, int scoreTeamB){

        TextView textView1 = findViewById(R.id.fcb_points);
        TextView textView2 = findViewById(R.id.rm_points);
        String pointsText = getResources().getString(R.string.points);

        if (scoreTeamA > scoreTeamB){
            textView1.setText(String.format(Locale.US, pointsText + "%d", 3));
            textView2.setText(String.format(Locale.US, pointsText + "%d", 0));
        }
        else if (scoreTeamB > scoreTeamA){
            textView2.setText(String.format(Locale.US, pointsText + "%d", 3));
            textView1.setText(String.format(Locale.US, pointsText + "%d", 0));
        }
        else{
            textView1.setText(String.format(Locale.US, pointsText + "%d", 1));
            textView2.setText(String.format(Locale.US, pointsText + "%d", 1));
        }
    }

    public void restartScore(View view){
        TextView textView1 = findViewById(R.id.fcb_points);
        TextView textView2 = findViewById(R.id.rm_points);
        String pointsText = getResources().getString(R.string.points);
        scoreTeamA = 0;
        scoreTeamB = 0;

        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
        textView1.setText(String.format(Locale.US, pointsText + "%d", 0));
        textView2.setText(String.format(Locale.US, pointsText + "%d", 0));
    }
}
