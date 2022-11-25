package com.example.zov.controller;

import com.example.zov.dto.AuthorBooksDto;
import com.example.zov.dto.AuthorsDto;
import com.example.zov.dto.BooksAuthorsDto;
import com.example.zov.service.author.AuthorService;
import com.example.zov.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping(
            value = "/get_by_id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorBooksDto getAuthorBooksById(@PathVariable("id") Long authorId) {
        return authorService.getAuthorBooksById(authorId);
    }

    @GetMapping(
            value = "/books_by_authors_{firstname}_{lastname}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorBooksDto getAuthorsBooksByFirstNameAndLastName(@PathVariable("firstname") String firstName,@PathVariable("lastname") String lastName) {
        return authorService.getAuthorsBooksByFirstNameAndLastName(firstName, lastName);
    }
    @GetMapping(
            value = "/get_all_unique_authors",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorsDto> getAllUniqueAuthors() {
        return authorService.getAllUniqueAuthors();
    }
    @GetMapping(
            value = "/get_authors_by_bound_{lowerbound}_{upperbound}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorsDto> getAuthorsByBound(@PathVariable("lowerbound") Long lowerBound, @PathVariable("upperbound") Long upperBound) {
        return authorService.getAuthorsByBounds(lowerBound , upperBound);
    }
    @GetMapping(
            value = "/get_authors_by_book_name_{bookname}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BooksAuthorsDto getAuthorsByBookName(@PathVariable("bookname") String bookName) {
        return bookService.getAuthorByBookName(bookName);
    }
}
