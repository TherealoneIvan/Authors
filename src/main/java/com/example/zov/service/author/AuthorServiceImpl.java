package com.example.zov.service.author;

import com.example.zov.dto.AuthorBooksDto;
import com.example.zov.dto.AuthorsDto;
import com.example.zov.entity.Author;
import com.example.zov.entity.Book;
import com.example.zov.repository.AuthorRepository;
import com.sun.source.tree.NewArrayTree;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public AuthorBooksDto getAuthorBooksById(Long id) {
        final var author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No author with such id"));
        final var books = author.getBooks().stream()
                .map(Book::getName)
                .collect(Collectors.toList());

        return new AuthorBooksDto(author.getFirstName(), author.getLastName(), books);
    }
    public AuthorBooksDto getAuthorsBooksByFirstNameAndLastName(String firstName , String lastName){
        final var author = authorRepository.findAuthorByFirstNameAndLastName(firstName , lastName)
                .orElseThrow(() -> new RuntimeException("No author with such first and last names"));
        System.out.println(author.getFirstName() + " " + author.getFirstName());
        final var books = author.getBooks().stream()
                .map(Book::getName)
                .collect(Collectors.toList());
        return new AuthorBooksDto(author.getFirstName(), author.getLastName(), books);
    }
    public List<AuthorsDto> getAllUniqueAuthors(){
        final var authors = authorRepository.findAll();
        List<AuthorsDto> allUniqueAuthors = new ArrayList<AuthorsDto>();
        for (Author ath : authors) {
            allUniqueAuthors.add(new AuthorsDto(ath.getFirstName() , ath.getLastName()));
        }
        return allUniqueAuthors;
    }

    public List<AuthorsDto> getAuthorsByBounds(Long lowerBound , Long upperBound){
        final var authors = authorRepository.findAuthorsByIdBetween(lowerBound , upperBound);
        List<AuthorsDto> allAuthorsInBounds = new ArrayList<AuthorsDto>();
        for (Author ath : authors) {
            allAuthorsInBounds.add(new AuthorsDto(ath.getFirstName() , ath.getLastName()));
        }
        return allAuthorsInBounds;
    }

}
