package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecylcerview;
    private bookRecyclerViewAdapter adapter;
    private ImageView downArrow,upArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new bookRecyclerViewAdapter(this);
        booksRecylcerview = findViewById(R.id.booksRecylerView);
        downArrow = findViewById(R.id.downArrow);
        upArrow = findViewById(R.id.upArrow);

        booksRecylcerview.setAdapter(adapter);
        booksRecylcerview.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<Book> Books  = new ArrayList<>();
        Books.add(new Book("Pride n Prejudice","Jane Eyre", 1, 328, "Good Book", "Great Book!", "http://goodbooksandgoodwine.com/wp-content/uploads/2014/02/Pride-And-Prejudice-Jane-Austen-Book-Cover.jpg"));
        Books.add(new Book("The Faults in our Stars","John Green",2,250,"Good","long good","https://images-na.ssl-images-amazon.com/images/I/51r27MDeQQL._SX324_BO1,204,203,200_.jpg"));

        adapter.setBooks(Books);
    }
}