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
import com.example.ada.library.api.FavoriteInterface;
import com.example.ada.library.model.Favorite;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ada on 18.01.2019.
 */

public class FavoriteFragment extends Fragment {


    private int position;
    Context context;
    private List<Favorite> favoriteList = new ArrayList<>();
    static String status;


    public static FavoriteFragment newInstance(int page) {
        FavoriteFragment myFragment = new FavoriteFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);

        myFragment.setArguments(args);


        return myFragment;
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

        FavoriteInterface favoriteClient = ApiClient.getClient().create(FavoriteInterface.class);

        Call<List<Favorite>> call = favoriteClient.getAllUserFavorites(new Long(1));
        call.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                favoriteList.addAll(response.body());
                recyclerView.setAdapter(new FavoriteListAdapter(favoriteList, recyclerView, context));
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                Toast.makeText(view.getContext(), "There are no books avaliable", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
