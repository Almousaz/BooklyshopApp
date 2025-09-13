package com.developeWtihAli.BooklyshopApp.bookSuggestions.service;


import com.developeWtihAli.BooklyshopApp.bookSuggestions.entity.Suggestions;

import java.util.List;


public interface SuggestionsService {

    Suggestions addSuggestion(Suggestions suggestion);

    List<Suggestions> getAllSuggestions();

    Suggestions markAsRead(String suggestionId);

}
