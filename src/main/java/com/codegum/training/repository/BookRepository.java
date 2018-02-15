package com.codegum.training.repository;

import com.codegum.training.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by juliusneria on 18/10/2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    Book findByTitle(String title);
    List<Book> findByGenre(String genre);
}
