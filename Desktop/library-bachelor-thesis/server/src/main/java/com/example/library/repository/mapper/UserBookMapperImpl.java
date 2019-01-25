package com.example.library.repository.mapper;

import com.example.library.model.UserBook;
import com.example.library.model.extensions.Status;
import com.example.library.model.extensions.UserBookIdentity;
import com.example.library.repository.dto.UserBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBookMapperImpl implements UserBookMapper {

    @Autowired
    private UserBookMapper delegate;


    @Override
    public UserBookDto userBookToUserBookDto(UserBook userBook) {
        UserBookDto userBookDto = new UserBookDto();
        userBookDto.setUserID(userBook.getUserBookIdentity().getUserID());
        userBookDto.setBookID(userBook.getUserBookIdentity().getBookID());
        userBookDto.setStatus(userBook.getStringStatus());
        userBookDto.setDownloadDate(userBook.getDownloadDate());
        return userBookDto;
    }

    //to bybły new String  user.setBookTitle(new String(userDto.getBookTitle()));
    @Override
    public UserBook userBookDtoToUserBook(UserBookDto userBookDto) {
        UserBook userBook=new UserBook();
        UserBookIdentity userBookIdentity = new UserBookIdentity(userBookDto.getUserID(), userBookDto.getBookID());
        userBook.setUserBookIdentity(userBookIdentity);
        userBook.setDownloadDate(userBookDto.getDownloadDate());
        /*
        switch (userBookDto.getStatus()) {
            case "DOWNLOADED":
                userBook.setStatus(Status.DOWNLOADED);
                break;
            case "WAITING":
                userBook.setStatus(Status.WAITING);
                break;
            case "FAVORITE":
                userBook.setStatus(Status.FAVORITE);
                break;
        }
        */
        userBook.setStatus(userBookDto.getStatus());

        return userBook;
    }

    public List<UserBookDto> userBooksToUserBookDtos(List<UserBook> userBookList) {
        List<UserBookDto> userBookDtoList = new ArrayList<>();
        userBookList.stream().forEach(userBook -> userBookDtoList.add(userBookToUserBookDto(userBook)));
        return userBookDtoList;
    }

    List<UserBook> userBookDtosToUserBookList(List<UserBookDto> userDtoList) {
        List<UserBook> userBookList = new ArrayList<>();
        userDtoList.stream().forEach(userBookDto -> userBookList.add(userBookDtoToUserBook(userBookDto)));
        return userBookList;
    }
}
