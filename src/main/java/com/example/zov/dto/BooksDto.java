package com.example.zov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto {
    @JsonProperty
    private Integer bookId;

    @JsonProperty
    private String bookName;

}
