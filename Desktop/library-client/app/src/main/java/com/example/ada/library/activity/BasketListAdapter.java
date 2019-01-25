package com.example.ada.library.activity;

import android.content.Context;
import android.content.Intent;
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
import com.example.ada.library.api.BasketBookInterface;
import com.example.ada.library.model.Basket;
import com.example.ada.library.model.BasketBook;
import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 22.01.2019.
 */

class BasketListAdapter extends RecyclerView.Adapter<BasketListAdapter.ViewHolder> {

    private List<BasketBook> basketBookList;
    private RecyclerView mrecyclerView;
    private Context mContext;


    public BasketListAdapter(List<BasketBook> baskets, RecyclerView recyclerView, Context context) {
        this.mrecyclerView = recyclerView;
        this.basketBookList = baskets;
        this.mContext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_basket_list_element, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {


        holder.title.setText(basketBookList.get(position).getBookTitle());
        holder.author.setText(basketBookList.get(position).getBookAuthors());
        holder.price.setText(basketBookList.get(position).getPrice() + " PLN");
        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        Picasso.with(holder.photo.getContext()).load(basketBookList.get(position).getBookCover()).into(holder.photo);


        /*

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, BookDetailsActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("id", booksList.get(position).getId());
                intent.putExtra("title",booksList.get(position).getTitle());
                intent.putExtra("authorsName",booksList.get(position).getAuthorsNames());
                intent.putExtra("ISBN",booksList.get(position).getISBN());
                intent.putExtra("DOI",booksList.get(position).getDOI());
                intent.putExtra("photo",booksList.get(position).getAddressURLOfPhoto());
                intent.putExtra("adressURL",booksList.get(position).getAdressURLOfResource());
                intent.putExtra("price", booksList.get(position).getPrice());
                mContext.startActivity(intent);
            }
        });


*/
        holder.removeFromBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BasketBook basketBook= new BasketBook(basketBookList.get(position).getBasketID(), basketBookList.get(position).getBookID(), Long.valueOf(1));

                BasketBookInterface basketBookClient = ApiClient.getClient().create(BasketBookInterface.class);
                Call<BasketBook> call = basketBookClient.removeBookFromBasketBook(basketBook);
                call.enqueue(new Callback<BasketBook>() {
                    @Override
                    public void onResponse(Call<BasketBook> call, Response<BasketBook> response) {
                        //
                        if (response.code()== HttpURLConnection.HTTP_OK) {
                            Intent i = new Intent(mContext, BasketActivity.class);
                            mContext.startActivity(i);
                            ((BasketActivity)mContext).finish();
                        }
                        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            Toast.makeText(mContext, "Book has been already removed from basket", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BasketBook> call, Throwable t) {

                        Toast.makeText(mContext, "Errir", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }

    @Override
    public int getItemCount() {
        return basketBookList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView author;
        public final TextView price;
        public final ImageView photo;
        public final ImageButton removeFromBasket;
        //public final ImageButton favorite;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            price = (TextView) view.findViewById(R.id.text_view_price);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
            removeFromBasket = (ImageButton) view.findViewById(R.id.image_remove);
            //favorite= (ImageButton) view.findViewById(R.id.image_favorite);
        }

    }


}
