/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for Teams
    int scoreTeamB = 0;
    ScoreViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets the View Model Reference
        mScoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        displayForTeamA(mScoreViewModel.ScoreTeamA); // Load from the View Model on config change

    }
// region updates Team A using ViewModel to store data
    /**
     * Update the score for Team A by 1 point using the View Model instance variables
     */
    public void addOneForTeamA(View v) {
        mScoreViewModel.ScoreTeamA++;
        displayForTeamA(mScoreViewModel.ScoreTeamA);
    }
    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mScoreViewModel.ScoreTeamA = mScoreViewModel.ScoreTeamA + 2;
        displayForTeamA(mScoreViewModel.ScoreTeamA);
    }
    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mScoreViewModel.ScoreTeamA = mScoreViewModel.ScoreTeamA + 3;
        displayForTeamA(mScoreViewModel.ScoreTeamA);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
// endregion updates Team A using ViewModel to store data

// region updates Team B using Activity to store data
    /**
     * Update the score for Team B by 1
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
// endregion updates Team B using Activity to store data

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        //Using ViewModel
        mScoreViewModel.ScoreTeamA = 0;
        displayForTeamA(mScoreViewModel.ScoreTeamA);
        //Using Activity class
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
    }
}
