package com.example.noteproject2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")

    private String mWord;

    public  Word(@Nullable String word){
        this.mWord = word;
    }

    public String getWord(){
        return this.mWord;
    }
}
