package com.example.ada.library.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ada.library.R;
import com.example.ada.library.model.Favorite;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ada on 18.01.2019.
 */

class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.ViewHolder> {

    private List<Favorite> favoritesList;
    private RecyclerView mrecyclerView;
    private Context mContext;

    public FavoriteListAdapter(List<Favorite> favorites, RecyclerView recyclerView, Context context) {
        this.mrecyclerView = recyclerView;
        this.favoritesList = favorites;
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_fav_list_element, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //holder.currentBook = booksList.get(position);
        holder.title.setText(favoritesList.get(position).getBookTitle());
        holder.author.setText(favoritesList.get(position).getBookAuthors());
        //holder.author.setText(favoritesList.get(position).getPrice().toString());
        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        //Picasso.with(holder.photo.getContext()).load(favoritesList.get(position).get()).into(holder.photo);


        Picasso.with(holder.photo.getContext()).load(favoritesList.get(position).getCoverOfBook()).into(holder.photo);

    }


    @Override
    public int getItemCount() {
        return favoritesList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView author;
        public final TextView price;
        public final ImageView photo;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            price = (TextView) view.findViewById(R.id.text_view_price);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
        }

    }
}
