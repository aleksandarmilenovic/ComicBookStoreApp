package com.example.alehandro.comicbookstore.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alehandro.comicbookstore.R;
import com.example.alehandro.comicbookstore.adapter.ComicAdapter;
import com.example.alehandro.comicbookstore.callbacks.OnListButtonClickCallback;
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

    private OnListButtonClickCallback onListButtonClickCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comiclist);

        comicRecycler = findViewById(R.id.comic_recycler);
        linearLayoutManager = new LinearLayoutManager(ComicListActivity.this);

        initComics();

        onListButtonClickCallback = new ComicListCallback();

        comicAdapter = new ComicAdapter(comics, ComicListActivity.this, onListButtonClickCallback);
        comicRecycler.setAdapter(comicAdapter);
        comicRecycler.setLayoutManager(linearLayoutManager);
    }

    private void initComics(){

        comics = new ArrayList<>();

        for (int i = 0; i < 30; i++){
            comics.add(new Comic("Comic "+i,"http://vignette4.wikia.nocookie.net/walkingdead/images/6/67/Volume_1-Days_Gone_Bye.jpg","GODINA "+i,"OPIS "+i,"CENA "+i));
        }

    }
    private class ComicListCallback implements OnListButtonClickCallback {
        @Override
        public void onButtonClick(Comic comic) {
            Intent intent = new Intent(ComicListActivity.this, ComicDetailsActivity.class);
            intent.putExtra(ComicDetailsActivity.COMIC_DETAILS_IMAGE_URL, comic.getSlikaURL());
            intent.putExtra(ComicDetailsActivity.COMIC_DEATILS_NAME, comic.getName());
            //getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            startActivity(intent);
        }
    }
}


