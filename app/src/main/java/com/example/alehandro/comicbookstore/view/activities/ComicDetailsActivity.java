package com.example.alehandro.comicbookstore.view.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alehandro.comicbookstore.R;
import com.squareup.picasso.Picasso;

public class ComicDetailsActivity extends AppCompatActivity{

    public static final String COMIC_DETAILS_IMAGE_URL = "imageUrl";
    public static final String COMIC_DEATILS_NAME = "name";
    public static final String COMIC_DETAILS_OPIS = "opis";
    public static final String COMIC_DETAILS_GODINA = "godina";

    private ImageView coverImageView;
    private TextView nameTextView;
    private TextView opsiTextView;
    private TextView godinaTextView;

    private String imageUrl;
    private String name;
    private String opis;
    private String godina;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comicdetails);

        imageUrl = getIntent().getStringExtra(COMIC_DETAILS_IMAGE_URL);
        name = getIntent().getStringExtra(COMIC_DEATILS_NAME);
        opis = getIntent().getStringExtra(COMIC_DETAILS_OPIS);
       godina = getIntent().getStringExtra(COMIC_DETAILS_GODINA);

        coverImageView = findViewById(R.id.comic_details_cover);
        nameTextView = findViewById(R.id.comic_details_name);
        opsiTextView = findViewById(R.id.comic_details_opis);
        godinaTextView = findViewById(R.id.comic_details_godina);

        Log.d("OPIS",opis);

        Picasso.with(this).load(imageUrl).placeholder(R.mipmap.placeholder)
                .error(R.mipmap.placeholder).into(coverImageView);

        nameTextView.setText(name);
        opsiTextView.setText("OPIS");
        godinaTextView.setText(godina);
    }

}
