package com.example.library.repository.dto;


public class BookDto {

    private Long id;

    private String ISBN;

    private String title;

    private String category;

    private String authorsNames;


    public BookDto() {

    }

    public BookDto(Long id, String ISBN, String title) {

        this.id = id;
        this.ISBN = ISBN;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuhorsNames() {
        return authorsNames;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorsNames(String authorsNames) {
        this.authorsNames = authorsNames;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
