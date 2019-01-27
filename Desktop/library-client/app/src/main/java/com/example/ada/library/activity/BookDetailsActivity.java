package com.example.ada.library.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ada.library.R;
import com.example.ada.library.api.ApiClient;
import com.example.ada.library.api.BasketBookInterface;
import com.example.ada.library.api.FavoriteInterface;
import com.example.ada.library.model.BasketBook;
import com.example.ada.library.model.Favorite;
import com.squareup.picasso.Picasso;

import java.net.HttpURLConnection;
import java.text.NumberFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 10.01.2019.
 */

public class BookDetailsActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetails);

        context=this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Library");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        progressDialog = new ProgressDialog(BookDetailsActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        final Intent i = getIntent();
        final int position = i.getExtras().getInt("position");

        final Long bookID = i.getExtras().getLong("id");
        String title = i.getExtras().getString("title");
        String authors = i.getExtras().getString("authorsName");
        String isbn = i.getExtras().getString("ISBN");
        String dio = i.getExtras().getString("DOI");
        String photo = i.getExtras().getString("photo");
        String adressURL = i.getExtras().getString("adressURL");
        float price=i.getExtras().getFloat("price");

        progressDialog.dismiss();

        TextView text_title= (TextView)findViewById(R.id.text_title);
        text_title.setText(title);
        TextView text_author= (TextView)findViewById(R.id.text_author);
        text_author.setText(authors);
        TextView text_isbn= (TextView)findViewById(R.id.text_isbn);
        text_isbn.setText("ISBN: " + isbn);
        TextView text_doi= (TextView)findViewById(R.id.text_doi);
        text_doi.setText("DOI: " + dio);
        TextView text_price = (TextView) findViewById(R.id.text_price);

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        String pric=formatter.format(price);
        text_price.setText(pric+ " PLN");
        ImageView image = (ImageView) findViewById(R.id.image_book);
        Picasso.with(image.getContext()).load(photo).into(image);


        Button buttonFavorite = (Button) findViewById(R.id.button_favorite);
        buttonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorite favorite= new Favorite(Long.valueOf(1), bookID);


                FavoriteInterface favoriteClient = ApiClient.getClient().create(FavoriteInterface.class);
                Call<Favorite> call = favoriteClient.addBookToFavorites(favorite);
                call.enqueue(new Callback<Favorite>() {
                    @Override
                    public void onResponse(Call<Favorite> call, Response<Favorite> response) {
                        //
                        if (response.code()== HttpURLConnection.HTTP_OK) {
                            Toast.makeText(context, "Book is add to favorite", Toast.LENGTH_SHORT).show();
                        }
                        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            Toast.makeText(context, "Book has been already added to favorite", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Favorite> call, Throwable t) {

                        Toast.makeText(context, "Errir", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button buttonBasket = (Button) findViewById(R.id.button_buy);
        buttonBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasketBook basketBook= new BasketBook(Long.valueOf(1), bookID);

                BasketBookInterface basketBookClient = ApiClient.getClient().create(BasketBookInterface.class);
                Call<BasketBook> call = basketBookClient.addBookToBasketBook(basketBook);
                call.enqueue(new Callback<BasketBook>() {
                    @Override
                    public void onResponse(Call<BasketBook> call, Response<BasketBook> response) {
                        //
                        if (response.code()== HttpURLConnection.HTTP_OK) {
                            Toast.makeText(context, "Book is add to basket", Toast.LENGTH_SHORT).show();
                        }
                        if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            Toast.makeText(context, "Book has been already added to basket", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BasketBook> call, Throwable t) {

                        Toast.makeText(context, "Errir", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.all_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_basket) {
            Intent i = new Intent(this, BasketActivity.class);
            startActivity(i);
            finish();
        }



        if (id == R.id.action_library) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }


        if (id == R.id.action_userbook) {

            Intent i = new Intent(this, UserBookActivity.class);
            i.putExtra("position", 0);
            startActivity(i);
            finish();

        }

        if (id == R.id.action_logout) {

              /*Intent i = new Intent(getApplicationContext(), LogInActivity.class);
          i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("id", id);
            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);
            */

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
