package com.example.ada.library.activity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ada.library.R;
import com.example.ada.library.api.ApiClient;
import com.example.ada.library.api.BasketBookInterface;
import com.example.ada.library.model.BasketBook;


import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        context = this;


        loadData();



        TextView text_amount = (TextView) findViewById(R.id.text_wholeAmount);
        text_amount.setText(amount+ " PLN");

        Button button_pay = (Button) findViewById(R.id.button_pay);
        button_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i <basketBookList.size(); i++) {
                    if (basketBookList.get(i)!=null) {
                        amount += basketBookList.get(i).getPrice();
                    }
                }


                String ulr= "https://ssl.dotpay.pl/test_payment/?id=758379&amount=" +amount+"&currency=PLN&description=Test";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://android.okhelp.cz/category/software/"));
                startActivity(browserIntent);

            }
        });
    }



    private void loadData() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rycle_view_basket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        BasketBookInterface basketClient = ApiClient.getClient().create(BasketBookInterface.class);
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
