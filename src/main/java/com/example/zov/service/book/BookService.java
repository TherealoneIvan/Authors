package com.example.zov.service.book;

import com.example.zov.dto.BooksAuthorsDto;

import java.util.List;

public interface BookService {
    BooksAuthorsDto getAuthorByBookName(String name);
}
