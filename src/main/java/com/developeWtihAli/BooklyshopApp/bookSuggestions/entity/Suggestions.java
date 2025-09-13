package com.developeWtihAli.BooklyshopApp.bookSuggestions.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "suggestions")
public class Suggestions {

    @Id
    private String id;

    private String name;

    private String email;

    private String bookTitle;

    private String authorName;

    private String status;
}
