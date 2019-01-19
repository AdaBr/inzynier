package com.example.ada.library.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ada.library.R;
import com.example.ada.library.api.ApiClient;
import com.example.ada.library.api.BookInterface;
import com.example.ada.library.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<Book> bookList = new ArrayList<>();
    ProgressDialog progressDialog;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_test);

        context=this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Library");
        setSupportActionBar(toolbar);


        loadData(true, "");

        final EditText editText= (EditText) findViewById(R.id.search_edit_frame);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    loadData(false, editText.getText().toString());
                    return true;
                }
                return false;
            }
        });

        ImageButton imageClearButton=(ImageButton) findViewById(R.id.image_clear);
        imageClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                loadData(true, "");

            }
        });

        ImageButton imageSearchButton = (ImageButton) findViewById(R.id.image_search);
        imageSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar_layout) ;
                appBar.setExpanded(true);
            }
        });

        ImageButton imageSortButton = (ImageButton) findViewById(R.id.image_sort);
        imageSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collections.sort(bookList, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {

                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                });

                final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.base_list);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(new BooksListAdapter(bookList, recyclerView, context));


            }
        });

    }

    private void loadData(boolean all, String query) {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.base_list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        BookInterface bookClient = ApiClient.getClient().create(BookInterface.class);
        Call<List<Book>> call;
        if (all==true) {
            call = bookClient.getAllBooks();
        }
        else {
            call = bookClient.getBookBySearach(query);
        }
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                progressDialog.dismiss();
                bookList.removeAll(bookList);
                bookList.addAll(response.body());
                recyclerView.setAdapter(new BooksListAdapter(bookList, recyclerView, context));
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "There are no books avaliable", Toast.LENGTH_LONG).show();
            }
        });

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

        if (id == R.id.action_userbook) {

            Intent i = new Intent(context, UserBookActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("id", id);
            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);

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


}
