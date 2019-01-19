package com.example.ada.library.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ada.library.R;
import com.example.ada.library.api.ApiClient;
import com.example.ada.library.api.UserBookInterface;
import com.example.ada.library.model.UserBook;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 17.01.2019.
 */

public class UserBookActivity extends AppCompatActivity {

    private List<UserBook> userBookList = new ArrayList<>();
    ProgressDialog progressDialog;
    Context context;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_book);

        context=this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("Library");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Library");
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);

        final ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager_usertabs);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());

        vpPager.setAdapter(adapterViewPager);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        vpPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }



        /*


        progressDialog = new ProgressDialog(UserBookActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.base_list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        UserBookInterface userBookClient = ApiClient.getClient().create(UserBookInterface.class);
        Call<List<UserBook>> call = userBookClient.getUserBooksWithStatus(new Long(1), "DOWNLOADED");
        call.enqueue(new Callback<List<UserBook>>() {
            @Override
            public void onResponse(Call<List<UserBook>> call, Response<List<UserBook>> response) {
                progressDialog.dismiss();
                userBookList.addAll(response.body());
                recyclerView.setAdapter(new UserBooksListAdapter(userBookList, recyclerView, context));
            }

            @Override
            public void onFailure(Call<List<UserBook>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "There are no books avaliable", Toast.LENGTH_LONG).show();
            }
        });


        //SearchView searchView= (SearchView) findViewById(R.id.search_view);
  }
*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_library) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("id", id);
            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);
        }
        if (id == R.id.action_logout) {
            Intent i = new Intent(getApplicationContext(), LogInActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            i.putExtra("id", id);
            startActivity(i);
            //overridePendingTransition(R.animator.animacja, R.animator.animacja);

        }

        return super.onOptionsItemSelected(item);
    }
}
