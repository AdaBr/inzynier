package com.example.library.author;

public class AuthorDto {

    private Long id;

    private  String surname;

    private String forename;

    public AuthorDto() {

    }

    AuthorDto(String surname, String forename) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
    }

    AuthorDto(Long id, String surname, String forename) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDto)) return false;

        AuthorDto authorDto = (AuthorDto) o;

        if (id != null ? !id.equals(authorDto.id) : authorDto.id != null) return false;
        if (forename != null ? !forename.equals(authorDto.forename) : authorDto.forename != null) return false;
        return surname != null ? !surname.equals(authorDto.surname) : authorDto.surname == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (forename != null ? forename.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

}
