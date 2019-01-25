package com.example.ada.library.activity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ada.library.R;
import com.example.ada.library.api.ApiClient;
import com.example.ada.library.api.FavoriteInterface;
import com.example.ada.library.model.Favorite;
import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        holder.price.setText(favoritesList.get(position).getPrice() + " PLN");
        //holder.author.setText(favoritesList.get(position).getPrice().toString());
        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        //Picasso.with(holder.photo.getContext()).load(favoritesList.get(position).get()).into(holder.photo);


        Picasso.with(holder.photo.getContext()).load(favoritesList.get(position).getCoverOfBook()).into(holder.photo);


        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorite favorite= new Favorite(new Long(1), favoritesList.get(position).getBookID());

                FavoriteInterface favoriteClient = ApiClient.getClient().create(FavoriteInterface.class);
                Call<Favorite> call = favoriteClient.removeBookFromFavorites(favorite);
                call.enqueue(new Callback<Favorite>() {
                    @Override
                    public void onResponse(Call<Favorite> call, Response<Favorite> response) {
                        //
                        if (response.code()== HttpURLConnection.HTTP_OK) {
                            //Toast.makeText(mContext, "Book is remove from favorite", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(mContext, UserBookActivity.class);
                            i.putExtra("position", 1);
                            mContext.startActivity(i);
                            ((UserBookActivity)mContext).finish();


                        }
                        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            //Toast.makeText(mContext, "Book can be remove from favorite", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Favorite> call, Throwable t) {

                        //Toast.makeText(mContext, "Book has been already remove from favorite", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

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
        public final ImageButton remove;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            price = (TextView) view.findViewById(R.id.text_view_price);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
            remove = (ImageButton) view.findViewById(R.id.image_remove);
        }

    }
}
