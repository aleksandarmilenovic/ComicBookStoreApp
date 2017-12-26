package com.example.alehandro.comicbookstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alehandro.comicbookstore.R;
import com.example.alehandro.comicbookstore.callbacks.OnListButtonClickCallback;
import com.example.alehandro.comicbookstore.model.Comic;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by alehandro on 1.12.17..
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private static final String TAG = "ComicAdapter";
    private ArrayList<Comic> comics;
    private Context context;
    private WeakReference<OnListButtonClickCallback> onListButtonClickCallback;


    public ComicAdapter(ArrayList<Comic> comics, Context context, OnListButtonClickCallback callback){
        this.comics = comics;
        this.context = context;
        onListButtonClickCallback = new WeakReference<OnListButtonClickCallback>(callback);
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_item, parent, false);

        return new ComicViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, final int position) {
        holder.comicNameTextView.setText(comics.get(position).getComicbook() == null ? "No name" : comics.get(position).getComicbook());
        holder.comicGodinaTextView.setText(comics.get(position).getGodina());
        holder.comicOpisTextView.setText("na");
        holder.comicCenaTextView.setText("na");
        holder.comicKupiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG,comics.get(position).getComicbook());
                onListButtonClickCallback.get().onButtonClick(comics.get(position));
            }
        });
        Picasso.with(context).load("http://vignette4.wikia.nocookie.net/walkingdead/images/6/67/Volume_1-Days_Gone_Bye.jpg").placeholder(R.mipmap.placeholder)
                .error(R.mipmap.placeholder).into(holder.comicCoverImageView);
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {

        TextView comicNameTextView;
        TextView comicGodinaTextView;
        TextView comicSlikaTextView;
        TextView comicOpisTextView;
        TextView comicCenaTextView;
        Button comicKupiButton;
        ImageView comicCoverImageView;

        public ComicViewHolder(View view){
            super(view);

            comicNameTextView = view.findViewById(R.id.comic_list_item_name);
            comicGodinaTextView = view.findViewById(R.id.comic_list_item_godina);
            comicOpisTextView = view.findViewById(R.id.comic_list_item_opis);
            comicCenaTextView = view.findViewById(R.id.comic_list_item_cena);
            comicKupiButton = view.findViewById(R.id.comic_list_item_kupi);
            comicCoverImageView = view.findViewById(R.id.comic_list_item_cover);

        }
    }

    public void setData(ArrayList<Comic> comics){
        this.comics = comics;
    }
}
