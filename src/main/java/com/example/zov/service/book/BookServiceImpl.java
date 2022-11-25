package com.example.zov.service.book;

import com.example.zov.dto.AuthorBooksDto;
import com.example.zov.dto.BooksAuthorsDto;
import com.example.zov.entity.Author;
import com.example.zov.entity.Book;
import com.example.zov.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    public BooksAuthorsDto getAuthorByBookName(String name){
        final var book = bookRepository.findBookByName(name)
                .orElseThrow(() -> new RuntimeException("No book with such name"));

        final var authors = book.getAuthors().stream()
                .map(a -> a.getFirstName() + " " + a.getLastName())
                .collect(Collectors.toList());

        return new BooksAuthorsDto(book.getName(), authors);
    }
}
