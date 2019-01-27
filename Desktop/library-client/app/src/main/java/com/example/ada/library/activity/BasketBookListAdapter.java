package com.example.ada.library.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.ada.library.model.BasketBook;
import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;
import java.text.NumberFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 22.01.2019.
 */

class BasketBookListAdapter extends RecyclerView.Adapter<BasketBookListAdapter.ViewHolder> {

    private List<BasketBook> basketBookList;
    private RecyclerView mrecyclerView;
    private Context mContext;


    public BasketBookListAdapter(List<BasketBook> baskets, RecyclerView recyclerView, Context context) {
        this.mrecyclerView = recyclerView;
        this.basketBookList = baskets;
        this.mContext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_downloaded_list_element, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {


        holder.title.setText(basketBookList.get(position).getBookTitle());
        holder.author.setText(basketBookList.get(position).getBookAuthors());

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        String pric=formatter.format(basketBookList.get(position).getPrice());
        holder.price.setText(pric + " PLN");


        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        Picasso.with(holder.photo.getContext()).load(basketBookList.get(position).getBookCover()).resize(100, 150).into(holder.photo);


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
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ulr = basketBookList.get(position).getAddressURL();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(ulr));
                mContext.startActivity(browserIntent);

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
        public final ImageButton download;
        //public final ImageButton favorite;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            price = (TextView) view.findViewById(R.id.text_view_price);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
            download = (ImageButton) view.findViewById(R.id.image_download);
            //favorite= (ImageButton) view.findViewById(R.id.image_favorite);
        }

    }


}
