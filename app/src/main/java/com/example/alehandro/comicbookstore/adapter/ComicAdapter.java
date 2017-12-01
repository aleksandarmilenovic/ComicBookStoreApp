package com.example.alehandro.comicbookstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alehandro.comicbookstore.R;
import com.example.alehandro.comicbookstore.model.Comic;

import java.util.ArrayList;

/**
 * Created by alehandro on 1.12.17..
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private ArrayList<Comic> comics;
    //private Context context;

    public ComicAdapter(ArrayList<Comic> comics, Context context){
        this.comics = comics;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_item, parent, false);

        return new ComicViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        holder.comicNameTextView.setText(comics.get(position).getName());
        //holder.comicNameTextView.setText(comics.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {

        TextView comicNameTextView;
        ImageView comicCoverImageView;

        public ComicViewHolder(View view){
            super(view);

            comicNameTextView = (TextView) view.findViewById(R.id.comic_list_item_name);
            //     comicCoverImageView = (ImageView) view.findViewById(R.id.comic_list_item_cover);

        }
    }
}
