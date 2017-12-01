package com.example.alehandro.comicbookstore.view.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alehandro.comicbookstore.R;
import com.example.alehandro.comicbookstore.adapter.ComicAdapter;
import com.example.alehandro.comicbookstore.model.Comic;

import java.util.ArrayList;

/**
 * Created by alehandro on 1.12.17..
 */

public class ComicListActivity extends AppCompatActivity{

    private RecyclerView comicRecycler;
    private LinearLayoutManager linearLayoutManager;
    private ComicAdapter comicAdapter;
    private ArrayList<Comic> comics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comiclist);

        comicRecycler = (RecyclerView) findViewById(R.id.comic_recycler);
        linearLayoutManager = new LinearLayoutManager(ComicListActivity.this);


        initComics();

        comicAdapter = new ComicAdapter(comics, ComicListActivity.this);
        comicRecycler.setAdapter(comicAdapter);
        comicRecycler.setLayoutManager(linearLayoutManager);
    }

    private void initComics(){

        comics = new ArrayList<>();

        for (int i = 0; i < 30; i++){
            comics.add(new Comic("Comic "+i));
        }

    }
}
