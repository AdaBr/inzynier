package com.example.ada.library.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ada.library.R;
import com.example.ada.library.model.Basket;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ada on 18.01.2019.
 */

class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

    private List<Basket> basketList;
    private RecyclerView mrecyclerView;
    private Context mContext;
    private List<String> orderNumber = new ArrayList<>();

    //private final BookList.OnListFragmentInteractionListener mListener;


    public OrderListAdapter(List<Basket> userBooks, RecyclerView recyclerView, Context context) {
        this.mrecyclerView = recyclerView;
        this.basketList = userBooks;
        this.mContext = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_order_list_element, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        orderNumber.add("758379" + basketList.get(position).getUserID() + basketList.get(position).getBasketID());
        holder.orderNumber.setText("Order number: " + orderNumber.get(position));
        holder.status.setText("Status: " +basketList.get(position).getStatus());
        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        //Picasso.with(holder.photo.getContext()).load(basketList.get(position).get()).into(holder.photo);
        if (holder.date!=null) {
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String da= dt1.format( basketList.get(position).getRealizationDate());
            holder.date.setText("Date: " + da);
        }

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        String pric=formatter.format(basketList.get(position).getWholeAmount());
        holder.amount.setText("Total amount: " + pric +" PLN");



        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, BasketBookActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("id", basketList.get(position).getBasketID());
                String or=orderNumber.get(position);
                intent.putExtra("orderNumber", orderNumber.get(position));

                mContext.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return basketList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView orderNumber;
        public final TextView status;
        public final TextView date;
        public final TextView amount;



        public ViewHolder(View view) {
            super(view);
            mView = view;
            orderNumber = (TextView) view.findViewById(R.id.text_view_orderNumber);
            status = (TextView) view.findViewById(R.id.text_view_status);
            date = (TextView) view.findViewById(R.id.text_view_date);
            amount = (TextView) view.findViewById(R.id.text_view_amount);
        }

    }
}
