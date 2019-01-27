package com.example.ada.library.activity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ada.library.R;
import com.example.ada.library.api.ApiClient;
import com.example.ada.library.api.BasketBookInterface;
import com.example.ada.library.api.BasketInterface;
import com.example.ada.library.model.Basket;
import com.example.ada.library.model.BasketBook;


import java.net.HttpURLConnection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 22.01.2019.
 */

public class BasketActivity extends AppCompatActivity {


    Context context;
    List<BasketBook> basketBookList= new ArrayList<>();
    float amount=0;
    Basket basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Library");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();



        Button button_pay = (Button) findViewById(R.id.button_pay);
        button_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!basketBookList.isEmpty()) {

                    Basket basket= new Basket(Long.valueOf(1), basketBookList.get(0).getBasketID(), "BOUGHT");

                    BasketInterface basketClient = ApiClient.getClient().create(BasketInterface.class);
                    Call<Basket> call = basketClient.modifyBasket(basket);
                    call.enqueue(new Callback<Basket>() {
                        @Override
                        public void onResponse(Call<Basket> call, Response<Basket> response) {

                            if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                                Toast.makeText(context, "Book has been already added to basket", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Basket> call, Throwable t) {

                            Toast.makeText(context, "Errir", Toast.LENGTH_SHORT).show();
                        }
                    });



                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(2);
                    String amountFor=formatter.format(amount);

                    String desc = "Order number 758379" + basketBookList.get(0).getUserID() + basketBookList.get(0).getBasketID();
                    String ulr = "https://ssl.dotpay.pl/test_payment/?id=758379&amount=" + amountFor + "&currency=PLN&description=" + desc;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ulr));
                    startActivity(browserIntent);

                   //Intent i = new Intent(context, UserBookActivity.class);
                    //startActivity(i);
                    //finish();



                } else {
                    Toast.makeText(context, "The are no books in the basket", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }





    private void loadData() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rycle_view_basket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        final BasketBookInterface basketClient = ApiClient.getClient().create(BasketBookInterface.class);
        Call<List<BasketBook>> call = basketClient.getBooksFromUserBasketWithStatus(Long.valueOf(1), "WAITING");
        call.enqueue(new Callback<List<BasketBook>>() {
            @Override
            public void onResponse(Call<List<BasketBook>> call, Response<List<BasketBook>> response) {
                basketBookList.removeAll(basketBookList);
                basketBookList.addAll(response.body());
                recyclerView.setAdapter(new BasketListAdapter(basketBookList, recyclerView, context));

                for (int i=0; i <basketBookList.size(); i++) {
                    if (basketBookList.get(i)!=null) {
                        amount += basketBookList.get(i).getPrice();


                        NumberFormat formatter = NumberFormat.getNumberInstance();
                        formatter.setMinimumFractionDigits(2);
                        String pric="" + formatter.format(amount);
                        TextView text_amount = (TextView) findViewById(R.id.text_wholeAmount);
                        text_amount.setText("Total amount: "+pric+ " PLN");

                    }

                }

            }

            @Override
            public void onFailure(Call<List<BasketBook>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "There are no books avaliable", Toast.LENGTH_SHORT).show();
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
