package com.example.ada.library.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ada.library.R;
import com.example.ada.library.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ada on 17.01.2019.
 */

public class LogInActivity extends AppCompatActivity {


    private List<Book> bookList = new ArrayList<>();
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Library");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_basket) {

            Intent i = new Intent(context, BasketActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);

        }

        if (id == R.id.action_userbook) {

            Intent i = new Intent(context, UserBookActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("position", 0);
            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);

        }
        if (id == R.id.action_logout) {

            Intent i = new Intent(context, LogInActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("position", 0);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


}


