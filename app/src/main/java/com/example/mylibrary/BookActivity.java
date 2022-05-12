package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private Button alreadyReading, wantToRead, alreadyRead, addToFavs;
    private ImageView imgInBook;
    private TextView bookActivityBookName, bookActivityBookAuthor, bookActivityPgs, bookActivityDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        alreadyRead = findViewById(R.id.alreadyRead);
        alreadyReading = findViewById(R.id.alreadyReading);
        wantToRead = findViewById(R.id.wantToRead);
        addToFavs = findViewById(R.id.addToFavs);
        imgInBook = findViewById(R.id.imgInBook);
        bookActivityBookName = findViewById(R.id.bookActivityBookName);
        bookActivityBookAuthor = findViewById(R.id.bookActivityBookAuthor);
        bookActivityPgs = findViewById(R.id.bookActivityPgs);
        bookActivityDescription = findViewById(R.id.bookActivityDescription);


        Book book = new Book("Pride n Prejudice","Jane Eyre", 1, 328, "Good Book", "Great Book!", "http://goodbooksandgoodwine.com/wp-content/uploads/2014/02/Pride-And-Prejudice-Jane-Austen-Book-Cover.jpg");

        setData(book);
    }

    void setData(Book book){

        bookActivityBookName.setText(book.getName());
        bookActivityBookAuthor.setText(book.getAuthor());
        bookActivityPgs.setText(String.valueOf(book.getPgs()));
        bookActivityDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(imgInBook);
    }
}