package com.example.library.model.extensions;

import com.example.library.commons.DataValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Surname {

    @Column(name = "SURNAME")
    private String value;

    public Surname() {
    }

    public Surname(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void validate(String surname) {
        if (surname == null || surname.length() == 0) {
            throw new DataValidationException("Invalid surname");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surname)) return false;

        Surname surname = (Surname) o;

        return value != null ? value.equals(surname.value) : surname.value == null;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
