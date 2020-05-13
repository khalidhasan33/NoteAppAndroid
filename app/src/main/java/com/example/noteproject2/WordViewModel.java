package com.example.noteproject2;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository((application));
        mAllWords = mRepository.getmAllWords();
    }

    LiveData<List<Word>> getmAllWords(){ return  mAllWords; }

    public void insert(Word word) { mRepository.insert(word);}
}
