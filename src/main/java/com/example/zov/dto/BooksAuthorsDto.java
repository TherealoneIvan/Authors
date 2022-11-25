package com.example.zov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksAuthorsDto {

    @JsonProperty
    private String name;

    @JsonProperty
    private List<String> authors;

}
