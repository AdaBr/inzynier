package com.example.ada.library.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ada.library.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.base_list);





        //Toolbar toolbar = (Toolbar) findViewById(R.id.collapsing_search_toolbar);
        //setSupportActionBar(toolbar);

        /*



        ViewPager vpPager = (ViewPager) findViewById(R.id.view_pager);
        adapterViewPager = new PagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setCurrentItem(position);


        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    public void restConnection(View view) {

        textView = (TextView) findViewById(R.id.textViewResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        BookClient bookClient = retrofit.create(BookClient.class);

        Call<List<Book>> call = bookClient.getAllBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

                if(!response.isSuccessful()) {
                    textView.setText("code: " + response.code());
                    return;
                }

                List<Book> books = response.body();

                for (Book book : books) {
                    String content ="";
                    content+= "ID: " + book.getId() + "\n";
                    content+= "ISBN: " + book.getISBN() + "\n";
                    content+= "title: " + book.getTitle() + "\n\n";

                    textView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
    */
}
