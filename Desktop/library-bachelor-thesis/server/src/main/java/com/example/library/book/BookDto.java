package com.example.library.book;


public class BookDto {

    private Long ISBN;

    private String title;


    public BookDto() {

    }

    public BookDto(String title) {
        this.title = title;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
