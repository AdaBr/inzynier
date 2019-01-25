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
import com.example.ada.library.api.FavoriteInterface;
import com.example.ada.library.api.UserBookInterface;
import com.example.ada.library.model.BasketBook;
import com.example.ada.library.model.Book;
import com.example.ada.library.model.Favorite;
import com.example.ada.library.model.UserBook;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 10.01.2019.
 */

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ViewHolder> {

    private List<Book> booksList;
    private RecyclerView mrecyclerView;
    private Context mContext;

    //private final BookList.OnListFragmentInteractionListener mListener;


    public BooksListAdapter(List<Book> books, RecyclerView recyclerView, Context context) {
        this.mrecyclerView = recyclerView;
        this.booksList=books;
        this.mContext =context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_base_list_element, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //holder.currentBook = booksList.get(position);
        holder.title.setText(booksList.get(position).getTitle());
        holder.author.setText(booksList.get(position).getAuthorsNames());
        holder.price.setText(booksList.get(position).getPrice() + " PLN");
        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        Picasso.with(holder.photo.getContext()).load(booksList.get(position).getAddressURLOfPhoto()).into(holder.photo);

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

        holder.addToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BasketBook basketBook= new BasketBook(Long.valueOf(1),booksList.get(position).getId());

                BasketBookInterface basketBookClient = ApiClient.getClient().create(BasketBookInterface.class);
                Call<BasketBook> call = basketBookClient.addBookToBasketBook(basketBook);
                call.enqueue(new Callback<BasketBook>() {
                    @Override
                    public void onResponse(Call<BasketBook> call, Response<BasketBook> response) {
                        //
                        if (response.code()== HttpURLConnection.HTTP_OK) {
                            Toast.makeText(mContext, "Book is add to basket", Toast.LENGTH_SHORT).show();
                        }
                        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            Toast.makeText(mContext, "Book has been already added to basket", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BasketBook> call, Throwable t) {

                        Toast.makeText(mContext, "Errir", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        holder.addToFavortie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorite favorite= new Favorite(new Long(1), booksList.get(position).getId());


                FavoriteInterface favoriteClient = ApiClient.getClient().create(FavoriteInterface.class);
                Call<Favorite> call = favoriteClient.addBookToFavorites(favorite);
                call.enqueue(new Callback<Favorite>() {
                    @Override
                    public void onResponse(Call<Favorite> call, Response<Favorite> response) {
                        //
                        if (response.code()==HttpURLConnection.HTTP_OK) {
                            Toast.makeText(mContext, "Book is add to favorite", Toast.LENGTH_SHORT).show();
                        }
                        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            Toast.makeText(mContext, "Book has been already added to favorite", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Favorite> call, Throwable t) {

                        Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }


    @Override
    public int getItemCount() {
        return booksList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView author;
        public final TextView price;
        public final ImageView photo;
        public final ImageButton addToFavortie;
        public final ImageButton addToBasket;
        //public final ImageButton favorite;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            price = (TextView) view.findViewById(R.id.text_view_price);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
            addToFavortie = (ImageButton) view.findViewById(R.id.image_favorite);
            addToBasket = (ImageButton) view.findViewById(R.id.image_buy);
            //favorite= (ImageButton) view.findViewById(R.id.image_favorite);
        }

    }


     /*
    private String findAuthorsForBook(Book book) {
        String authors="";

        for (AuthorBook authorbook: authorsBooksList) {
            if (authorbook.getBookID().equals(book.getId())) {
                for (Author author : authorsList) {
                    if (authorbook.getAuthorID().equals(author.getId())) {
                        authors=author.getForename() + "" + author.getSurname() + ", ";
                    }
                }
            }
        }

        return authors.substring(0, authors.length()-2);
    }

    public void getAllAuthors(List<Author> authors) {
        authorsList.addAll(authors);
    }

    public void getAllAuthorsBooks(List<AuthorBook> authorsbooks) {
        authorsBooksList.addAll(authorsbooks);
    }

    */
}
