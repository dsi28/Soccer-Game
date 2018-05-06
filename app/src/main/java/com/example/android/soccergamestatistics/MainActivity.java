package com.example.android.soccergamestatistics;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    int foulA = 0;
    int foulB = 0;
    int tempSA = scoreA;
    int tempSB = scoreB;
    int tempFA = foulA;
    int tempFB = foulB;
    boolean justReset = false;
    String lastUpdate = "";
    TextView scoreTVB;
    TextView foulBTV;
    TextView foulTV;
    TextView scoreTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTVB = (TextView) findViewById(R.id.scoreB);
        foulBTV = (TextView) findViewById(R.id.foulB);
        foulTV = (TextView) findViewById(R.id.foulA);
        scoreTV = (TextView) findViewById(R.id.scoreA);
    }
    public void goalA(View view) {
        tempSA = scoreA;
        scoreA++;
        updateScoreA(scoreA);
        justReset = false;
        lastUpdate = "ga";
    }
    public void goalB(View view) {
        tempSB = scoreB;
        scoreB++;
        updateScoreB(scoreB);
        justReset = false;
        lastUpdate = "gb";
    }
    private void updateScoreB(int scoreB) {
        scoreTVB.setText("" + scoreB);
    }
    public void anulA(View view) {
        if (scoreA == 0) {
        } else {
            tempSA = scoreA;
            scoreA--;
            updateScoreA(scoreA);
            lastUpdate = "ga";
        }
        justReset = false;
    }
    public void anulB(View view) {
        if (scoreB == 0) {
        } else {
            tempSB = scoreB;
            scoreB--;
            updateScoreB(scoreB);
            lastUpdate = "gb";
        }
        justReset = false;
    }
    public void addFoulA(View view) {
        tempFA = foulA;
        foulA++;
        updateFoul(foulA);
        justReset = false;
        lastUpdate = "fa";
    }
    public void addFoulB(View view) {
        tempFB = foulB;
        foulB++;
        updateFoulB(foulB);
        justReset = false;
        lastUpdate = "fb";
    }
    public void minusFoulB(View view) {
        if (foulB == 0) {
        } else {
            tempFB = foulB;
            foulB--;
            updateFoulB(foulB);
            lastUpdate = "fb";
        }
        justReset = false;
    }
    private void updateFoulB(int foulB) {
        foulBTV.setText("" + foulB);
    }
    public void minusFoulA(View view) {
        if (foulA == 0) {
        } else {
            tempFA = foulA;
            foulA--;
            updateFoul(foulA);
            lastUpdate = "fa";
        }
        justReset = false;
    }
    private void updateFoul(int foulA) {
        foulTV.setText("" + foulA);
    }
    private void updateScoreA(int score) {
        scoreTV.setText("" + score);
    }
    public void reset(View view) {
        tempSA = scoreA;
        tempSB = scoreB;
        tempFA = foulA;
        tempFB = foulB;
        scoreA = scoreB = foulA = foulB = 0;
        updateAll(scoreA, scoreB, foulA, foulB);
        justReset = true;
    }
    public void undo(View view) {
        if (justReset == true) {
            scoreA = tempSA;
            scoreB = tempSB;
            foulA = tempFA;
            foulB = tempFB;
            updateAll(scoreA, scoreB, foulA, foulB);
        } else {
            if (lastUpdate.equals("ga")) {
                scoreA = tempSA;
                updateScoreA(scoreA);
            } else if (lastUpdate.equals("gb")) {
                scoreB=tempSB;
                updateScoreB(scoreB);
            }else if (lastUpdate.equals("fa")){
                foulA=tempFA;
                updateFoul(foulA);
            }else if(lastUpdate.equals("fb")){
                foulB=tempFB;
                updateFoulB(foulB);
            }
        }
    }
    private void updateAll(int sA, int sB, int fA, int fB) {
        updateScoreA(sA);
        updateScoreB(sB);
        updateFoul(fA);
        updateFoulB(fB);
    }
}
