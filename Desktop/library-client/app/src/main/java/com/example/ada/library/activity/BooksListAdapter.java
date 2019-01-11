package com.example.ada.library.activity;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ada.library.R;
import com.example.ada.library.api.BooksDetailsClient;
import com.example.ada.library.api.BooksDetailsClientImp;
import com.example.ada.library.entity.Author;
import com.example.ada.library.entity.AuthorBook;
import com.example.ada.library.entity.Book;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ada on 10.01.2019.
 */

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ViewHolder> {

    private List<Book> booksList;
    private List<AuthorBook> authorsBooksList;
    private List<Author> authorsList;

    BooksDetailsClientImp bookDetailsCleint;

    //private final BookList.OnListFragmentInteractionListener mListener;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_base_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.currentBook = booksList.get(position);
        holder.title.setText(booksList.get(position).getTitle());
        holder.author.setText(findAuthorsForBook(booksList.get(position)));


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
                */
            }
        });
    }

    private String findAuthorsForBook(Book book) {
        String authors="";

        for (AuthorBook authorbook: authorsBooksList) {
            if (authorbook.getBookID().equals(book.getId())) {
                for (Author author : authorsList) {
                    if (authorbook.getAuthorID().equals(author.getId())) {
                        authors=author.getForename() + "" + author.getSurname() + ", ";
                    }
                }
            }
        }

        return authors.substring(0, authors.length()-2);
    }


    @Override
    public int getItemCount() {
        return booksList.size();
    }


    public void getAllBooks(List<Book> books) {
        booksList.addAll(books);
    }

    public void getBooksBySearch(List<Book> books) {
        booksList.addAll(books);
    }

    public void getAllAuthors(List<Author> authors) {
        authorsList.addAll(authors);
    }

    public void getAllAuthorsBooks(List<AuthorBook> authorsbooks) {
        authorsBooksList.addAll(authorsbooks);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView author;
        public final TextView isbn;
        public final ImageView photo;
        public Book currentBook;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.text_view_title);
            author = (TextView) view.findViewById(R.id.text_view_author);
            isbn = (TextView) view.findViewById(R.id.text_view_isbn);
            photo = (ImageView) view.findViewById(R.id.image_view_book);
        }

    }
}
