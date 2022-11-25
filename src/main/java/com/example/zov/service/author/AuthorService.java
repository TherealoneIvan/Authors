package com.example.zov.service.author;

import com.example.zov.dto.AuthorBooksDto;
import com.example.zov.dto.AuthorsDto;
import com.sun.istack.NotNull;

import java.util.List;

public interface AuthorService {
    AuthorBooksDto getAuthorBooksById(@NotNull Long id);
    AuthorBooksDto getAuthorsBooksByFirstNameAndLastName(String firstName , String lastName);

    List<AuthorsDto> getAllUniqueAuthors();
    List<AuthorsDto> getAuthorsByBounds(Long lowerBound , Long upperBound);
}
