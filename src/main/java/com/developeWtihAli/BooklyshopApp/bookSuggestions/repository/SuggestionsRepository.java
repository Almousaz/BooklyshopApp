package com.developeWtihAli.BooklyshopApp.bookSuggestions.repository;

import com.developeWtihAli.BooklyshopApp.bookSuggestions.entity.Suggestions;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface SuggestionsRepository extends MongoRepository<Suggestions , String> {


}
