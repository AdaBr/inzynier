package com.example.library.repository.mapper;


import com.example.library.model.extensions.AuthorBookIdentity;
import com.example.library.model.AuthorBook;
import com.example.library.repository.dto.AuthorBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorBookMapperImpl implements AuthorBookMapper {

    @Autowired
    private AuthorBookMapper delegate;


    @Override
    public AuthorBook authorBookDtoToAuthorBook(AuthorBookDto authorbookDto) {
        AuthorBook authorBook=new AuthorBook();
        AuthorBookIdentity authorBookIdentity = new AuthorBookIdentity(authorbookDto.getAuthorID(), authorbookDto.getBookID());
        authorBook.setAuthorBookIdentity(authorBookIdentity);
        return authorBook;
    }

    @Override
    public AuthorBookDto authorBookToAuthorBookDto(AuthorBook authorBook) {
        AuthorBookDto authorBookDto = new AuthorBookDto();
        authorBookDto.setAuthorID(authorBook.getAuthorBookIdentity().getAuthorID());
        authorBookDto.setBookID(authorBook.getAuthorBookIdentity().getBookID());
        return authorBookDto;
    }




    public List<AuthorBookDto> authorBooksToAuthorBookDtos(List<AuthorBook> authorBookList) {
        List<AuthorBookDto> authorBookDtoList = new ArrayList<AuthorBookDto>();
        authorBookList.stream().forEach(authorBook -> authorBookDtoList.add(authorBookToAuthorBookDto(authorBook)));
        return authorBookDtoList;
    }

    public List<AuthorBook> authorBookDtosToAuthorBooks(List<AuthorBookDto> authorBookDtoList) {
        List<AuthorBook> authorBookList = new ArrayList<AuthorBook>();
        authorBookDtoList.stream().forEach(authorBookDto -> authorBookList.add(authorBookDtoToAuthorBook(authorBookDto)));
        return authorBookList;
    }


}
