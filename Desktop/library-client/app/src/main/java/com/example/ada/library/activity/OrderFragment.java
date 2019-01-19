package com.example.ada.library.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by ada on 18.01.2019.
 */

public class OrderFragment extends Fragment {


    private int position;
    Context context;
    private List<UserBook> userBookList = new ArrayList<>();
    static String status;


    public static OrderFragment newInstance(int page) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);

        orderFragment.setArguments(args);


        return orderFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("someInt", 0);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.user_tabs_fragment, container, false);


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyle_userbooks);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        UserBookInterface userBookClient = ApiClient.getClient().create(UserBookInterface.class);

        status = "DOWNLOADED";
        /*
        if (position == 0) {
            status = "DOWNLOADED";
        } else {
            status = "FAVORITE";
        }
        */

        Call<List<UserBook>> call = userBookClient.getUserBooksWithStatus(new Long(1), status);
        call.enqueue(new Callback<List<UserBook>>() {
            @Override
            public void onResponse(Call<List<UserBook>> call, Response<List<UserBook>> response) {
                userBookList.addAll(response.body());
                recyclerView.setAdapter(new UserBooksListAdapter(userBookList, recyclerView, context, status));
            }

            @Override
            public void onFailure(Call<List<UserBook>> call, Throwable t) {
                Toast.makeText(view.getContext(), "There are no books avaliable", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
