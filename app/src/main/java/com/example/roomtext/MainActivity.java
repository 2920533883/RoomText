package com.example.roomtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDatabase wordDatabase;
    WordDao wordDao;
    Button insertButton, deleteButton, clearButton, updateButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word_database").allowMainThreadQueries().build();
        wordDao = wordDatabase.getWordDao();
        insertButton = findViewById(R.id.button);
        deleteButton = findViewById(R.id.button3);
        clearButton = findViewById(R.id.button4);
        updateButton = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        updataView();



        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Apple", "苹果");
                Word word2 = new Word("Run", "跑");
                wordDao.insertWords(word1, word2);
                updataView();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Word word = new Word("Hi", "你好");
               word.setId(20);
               wordDao.updateWords(word);
               updataView();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordDao.deleteAllWords();
                updataView();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi", "你好");
                word.setId(17);
                wordDao.deleteWords(word);
                updataView();
            }
        });
    }

    void updataView(){
        List<Word> list = wordDao.getAllWords();
        StringBuilder text = new StringBuilder("");
        for (int i = 0; i < list.size(); ++i)
        {
            Word word = list.get(i);
            text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
        }
        textView.setText(text);
    }
}
