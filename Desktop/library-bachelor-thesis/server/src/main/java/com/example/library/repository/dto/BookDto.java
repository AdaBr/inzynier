package com.example.library.repository.dto;


public class BookDto {

    private Long id;

    private String ISBN;

    private String DOI;

    private String title;

    private String adressURLOfResource;

    private String addressURLOfPhoto;

    private String authorsNames;

    private String category;

    private Float price;

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

    public String getAuhorsNames() {
        return authorsNames;
    }

    public String getAdressURLOfResource() {
        return adressURLOfResource;
    }

    public void setAdressURLOfResource(String adressURLOfResource) {
        this.adressURLOfResource = adressURLOfResource;
    }

    public String getAddressURLOfPhoto() {
        return addressURLOfPhoto;
    }

    public void setAddressURLOfPhoto(String addressURLOfPhoto) {
        this.addressURLOfPhoto = addressURLOfPhoto;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getAuthorsNames() {
        return authorsNames;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
