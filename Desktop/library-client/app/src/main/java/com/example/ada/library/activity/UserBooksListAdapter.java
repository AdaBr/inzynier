package com.example.ada.library.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ada.library.R;
import com.example.ada.library.model.UserBook;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ada on 18.01.2019.
 */

class UserBooksListAdapter extends RecyclerView.Adapter<UserBooksListAdapter.ViewHolder> {

    private List<UserBook> userBooksList;
    private RecyclerView mrecyclerView;
    private Context mContext;
    private String status;

    //private final BookList.OnListFragmentInteractionListener mListener;


    public UserBooksListAdapter(List<UserBook> userBooks, RecyclerView recyclerView, Context context,String status) {
        this.mrecyclerView = recyclerView;
        this.userBooksList = userBooks;
        this.mContext = context;
        this.status=status;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_downloaded_list_element, parent, false);

        if (status=="FAVORITE") {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.one_fav_list_element, parent, false);
        }
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //holder.currentBook = booksList.get(position);
        holder.title.setText(userBooksList.get(position).getBookTitle());
        holder.author.setText(userBooksList.get(position).getBookAuthors());
        //String photoUrl= "https://ecsmedia.pl/c/instrukcja-obslugi-faceta-w-iext48615521.jpg";
        //Picasso.with(holder.photo.getContext()).load(userBooksList.get(position).get()).into(holder.photo);
        if (holder.date!=null) {
            holder.date.setText(userBooksList.get(position).getDownloadDate().toString());
        }

        Picasso.with(holder.photo.getContext()).load(userBooksList.get(position).getPhoto()).into(holder.photo);

    }


    @Override
    public int getItemCount() {
        return userBooksList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView author;
        public final TextView date;
        public final ImageView photo;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            date = (TextView) view.findViewById(R.id.text_view_date);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
        }

    }
}
