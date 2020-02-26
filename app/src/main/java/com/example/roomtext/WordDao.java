package com.example.roomtext;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertWords(Word... words);

    @Delete
    void deleteWords(Word... words);

    @Update
    void updateWords(Word... words);

    @Query("delete from word")
    void deleteAllWords();

    @Query("select * from word order by id desc")
    List<Word> getAllWords();
}
