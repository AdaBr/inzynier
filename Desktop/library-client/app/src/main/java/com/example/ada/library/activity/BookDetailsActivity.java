package com.example.ada.library.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ada.library.R;
import com.squareup.picasso.Picasso;

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


        Intent i = getIntent();
        int position = i.getExtras().getInt("id");

        String title = i.getExtras().getString("title");
        String authors = i.getExtras().getString("authorsName");
        String isbn = i.getExtras().getString("ISBN");
        String dio = i.getExtras().getString("DOI");
        String photo = i.getExtras().getString("photo");
        String adressURL = i.getExtras().getString("adressURL");

        progressDialog.dismiss();

        TextView text_title= (TextView)findViewById(R.id.text_title);
        text_title.setText(title);
        TextView text_author= (TextView)findViewById(R.id.text_author);
        text_author.setText(authors);
        TextView text_isbn= (TextView)findViewById(R.id.text_isbn);
        text_isbn.setText("ISBN: " + isbn);
        TextView text_doi= (TextView)findViewById(R.id.text_doi);
        text_doi.setText("DOI: " + dio);
        ImageView image = (ImageView) findViewById(R.id.image_book);

        Picasso.with(image.getContext()).load(photo).into(image);




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
        }


        if (id == R.id.action_userbook) {
            /*
            Intent i = new Intent(getApplicationContext(), UserBookActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("id", id);
            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);
            */

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
