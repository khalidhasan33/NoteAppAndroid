package com.example.noteproject2;

import java.io.Serializable;
import java.sql.Timestamp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word implements Comparable<Word>, Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "due")
    private String due;

    @ColumnInfo(name = "color")
    private int color;

    public  Word( String title, String desc, String due, int color, int id){
        this(title, desc, Timestamp.valueOf(due), color, id);
    }
    public  Word( String title, String desc, Timestamp due, int color){
        this(title,desc,due,color, 0);
    }
    public  Word( String title, String desc, Timestamp due, int color, int id){
        this.title = title;
        this.desc = desc;
        this.due = due.toString();
        this.color = color;
        this.id = id;
    }
    public String getTitle() { return this.title; }

    public Timestamp getDueTimestamp() { return Timestamp.valueOf(due); }

    public String getDue() { return this.due; }

    public Word getWord(){
        return this;
    }

    public String getDesc() {return this.desc;}

    public int getColor() {return this.color; }

    public int getId() {return id;}

    public void setId(int d) {this.id = id;}


    @Override
    public int compareTo(Word other) {
        return due.compareTo(other.due);
    }
}
