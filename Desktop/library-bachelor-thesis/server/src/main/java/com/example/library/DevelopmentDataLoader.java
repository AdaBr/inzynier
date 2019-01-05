package com.example.library;

import com.example.library.book.Book;
import com.example.library.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Transactional
public class DevelopmentDataLoader implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Book book =new Book("Pan Tadeusz");

        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name ->
                repository.save(new Beer(name))
        );
        repository.findAll().forEach(System.out::println);

    }
}
