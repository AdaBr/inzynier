package com.example.library.model.extensions;

import com.example.library.commons.DataValidationException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Forename {

    @Column(name = "FORENAME")
    private String value;

    public Forename() {

    }

    public Forename(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void validate(String forename) {
        if (forename == null || forename.length() == 0) {
            throw new DataValidationException("Invalid forename");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Forename)) return false;

        Forename forename = (Forename) o;

        return value != null ? value.equals(forename.value) : forename.value == null;
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
