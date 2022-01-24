package com.example.android.courtcounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    // Use Live data for the Team A score
    private final MutableLiveData<Integer> ScoreTeamA;

    //Constructor
    public ScoreViewModel(){
        ScoreTeamA = new MutableLiveData<>();
        ScoreTeamA.setValue(0);
    }
     public LiveData<Integer> getScoreTeamA() { return ScoreTeamA; }

    public void add(int points) {
        ScoreTeamA.setValue(ScoreTeamA.getValue()+points);
    }
}
