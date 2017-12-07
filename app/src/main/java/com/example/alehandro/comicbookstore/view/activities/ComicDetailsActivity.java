package com.example.alehandro.comicbookstore.view.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alehandro.comicbookstore.R;
import com.squareup.picasso.Picasso;

public class ComicDetailsActivity extends AppCompatActivity{

    public static final String COMIC_DETAILS_IMAGE_URL = "imageUrl";
    public static final String COMIC_DEATILS_NAME = "name";

    private ImageView coverImageView;
    private TextView nameTextView;

    private String imageUrl;
    private String name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comicdetails);

        imageUrl = getIntent().getStringExtra(COMIC_DETAILS_IMAGE_URL);
        name = getIntent().getStringExtra(COMIC_DEATILS_NAME);

        coverImageView = findViewById(R.id.comic_details_cover);
        nameTextView = findViewById(R.id.comic_details_name);


        Picasso.with(this).load(imageUrl).placeholder(R.mipmap.placeholder)
                .error(R.mipmap.placeholder).into(coverImageView);

        nameTextView.setText(name);
    }

}
