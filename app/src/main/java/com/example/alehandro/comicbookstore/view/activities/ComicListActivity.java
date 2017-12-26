package com.example.alehandro.comicbookstore.view.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Connection;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;


import com.example.alehandro.comicbookstore.R;
import com.example.alehandro.comicbookstore.adapter.ComicAdapter;
import com.example.alehandro.comicbookstore.callbacks.OnListButtonClickCallback;

import com.example.alehandro.comicbookstore.db.JSONParser;
import com.example.alehandro.comicbookstore.model.Comic;
import com.example.alehandro.comicbookstore.model.ServerResponse;
import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by alehandro on 1.12.17..
 */

public class ComicListActivity extends AppCompatActivity{

    private JSONArray strip = null;

    private RecyclerView comicRecycler;
    private LinearLayoutManager linearLayoutManager;
    private ComicAdapter comicAdapter;
    private ArrayList<Comic> comics;

    private OnListButtonClickCallback onListButtonClickCallback;
    private JSONParser jsonParser = new JSONParser();
    private String showURL = "http://igormedenica.com/raf/showComic.php";
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

        LoadAllComics loadAllComics = new LoadAllComics();
        loadAllComics.execute();

    }

    private void initComics(){

//        String showURL = "http://comicbookstore.byethost5.com/showComic.php";
//        JSONParser jsonParser = new JSONParser();
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        String ime = null;
//        String godina = null;
//        String brstrana = null;
//        String opis = null;
//        String slika = null;
//        String cena = null;
//        params.add(new BasicNameValuePair("ime", ime));
//        params.add(new BasicNameValuePair("godina", godina));
//        params.add(new BasicNameValuePair("brstrana",brstrana));
//        params.add(new BasicNameValuePair("opis",opis));
//        params.add(new BasicNameValuePair("slika",slika));
//        params.add(new BasicNameValuePair("cena",cena));
//        JSONObject json = jsonParser.makeHttpRequest(showURL,
//                "GET", params);
//
//        Log.d("Create Response", json.toString());


        comics = new ArrayList<>();


//        for (int i = 0; i < 30; i++){
//            comics.add(new Comic("Comic "+i,"http://vignette4.wikia.nocookie.net/walkingdead/images/6/67/Volume_1-Days_Gone_Bye.jpg","GODINA "+i,"OPIS "+i,"CENA "+i));
//        }

    }
    private class ComicListCallback implements OnListButtonClickCallback {
        @Override
        public void onButtonClick(Comic comic) {
            Intent intent = new Intent(ComicListActivity.this, ComicDetailsActivity.class);
            intent.putExtra(ComicDetailsActivity.COMIC_DETAILS_IMAGE_URL, comic.getSlikaURL());
            intent.putExtra(ComicDetailsActivity.COMIC_DEATILS_NAME, comic.getComicbook());
            //getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }

    class LoadAllComics extends AsyncTask<String,String ,ArrayList<Comic>> {

        private ProgressDialog progressDialog;

        @Override
        protected ArrayList<Comic> doInBackground(String... strings) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            JSONObject json = jsonParser.makeHttpRequest(showURL, "GET", params);

            Gson gson = new Gson();

            ServerResponse serverResponse = gson.fromJson(json.toString(),ServerResponse.class);
            Log.e("SUCCESS",serverResponse.getSuccess()+"");

            ArrayList<Comic> comics = serverResponse.getCart();

            Log.v("CL", comics.size()+"");

            for (int i = 0; i < comics.size(); i++){
                Log.v("COMIC NAME", comics.get(i).getComicbook());
            }

           // Log.e("XXX","ssssssssssssssssssssssssssssss");



            return comics;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ComicListActivity.this);
            progressDialog.setMessage("Loading comicboks please wait.....");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<Comic> c) {

            progressDialog.dismiss();
//            runOnUiThread(new Runnable() {
//                public void run() {
//                    comics = c;
//                }
//            });

            comicAdapter.setData(c);
            comicAdapter.notifyDataSetChanged();
        }
    }


}


