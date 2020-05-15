package com.example.noteproject2;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY due ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Word word);


}
