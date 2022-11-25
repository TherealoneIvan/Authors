package com.example.zov.repository;

import com.example.zov.entity.Author;
import com.example.zov.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
    Iterable<Author> findAuthorsByIdBetween(Long id, Long id2);

}
