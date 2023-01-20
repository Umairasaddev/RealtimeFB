package com.example.realtimefb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);

        mRecyclerview = findViewById(R.id.recyclerview_books);
        new FirebaseDatabaseHelper().readBooks(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataisLoaded(List<Book> books, List<String> keys) {
                new Recyclerview_config().setConfig(mRecyclerview,BookListActivity.this,
                         books,keys);
            }

            @Override
            public void DataisInserted() {

            }

            @Override
            public void DataisUpdated() {

            }

            @Override
            public void DataisDeleted() {

            }
        });
    }
}