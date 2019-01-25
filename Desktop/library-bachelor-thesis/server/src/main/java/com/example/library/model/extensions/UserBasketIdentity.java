package com.example.library.model.extensions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserBasketIdentity implements Serializable {

    @Column(name = "user_id")
    @NotNull
    private Long userID;

    @Column(name = "basket_id")
    @NotNull
    private Long basketID;

    public UserBasketIdentity() {

    }

    public UserBasketIdentity(Long userID, Long basketID) {

        this.userID = userID;
        this.basketID = basketID;
    }

    public Long getBasketID() {
        return basketID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setBasketID(Long basketID) {
        this.basketID = basketID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBasketIdentity)) return false;
        UserBasketIdentity that = (UserBasketIdentity) o;
        return Objects.equals(getUserID(),that.getUserID())
                && Objects.equals(getBasketID(), that.getBasketID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getBasketID());
    }


}
