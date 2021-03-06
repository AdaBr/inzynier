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
import com.example.ada.library.api.BasketInterface;
import com.example.ada.library.model.Basket;

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
    private List<Basket> basketList = new ArrayList<>();
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


        context=this.getContext();

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyle_userbooks);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        BasketInterface basketClient = ApiClient.getClient().create(BasketInterface.class);



        Call<List<Basket>> call = basketClient.getBasketWithStatusForUser(new Long(1), "BOUGHT");
        call.enqueue(new Callback<List<Basket>>() {
            @Override
            public void onResponse(Call<List<Basket>> call, Response<List<Basket>> response) {
                basketList.addAll(response.body());
                recyclerView.setAdapter(new OrderListAdapter(basketList, recyclerView, context));
            }

            @Override
            public void onFailure(Call<List<Basket>> call, Throwable t) {
                Toast.makeText(view.getContext(), "There are no books avaliable", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
