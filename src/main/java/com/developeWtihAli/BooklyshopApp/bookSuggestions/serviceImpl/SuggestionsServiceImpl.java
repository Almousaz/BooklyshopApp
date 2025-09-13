package com.developeWtihAli.BooklyshopApp.bookSuggestions.serviceImpl;


import com.developeWtihAli.BooklyshopApp.bookSuggestions.entity.Suggestions;
import com.developeWtihAli.BooklyshopApp.bookSuggestions.repository.SuggestionsRepository;
import com.developeWtihAli.BooklyshopApp.bookSuggestions.service.SuggestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuggestionsServiceImpl implements SuggestionsService {


    @Autowired
    private SuggestionsRepository suggestionsRepository;


    @Override
    public Suggestions addSuggestion(Suggestions suggestion) {
        suggestion.setStatus("PENDING");
        return suggestionsRepository.save(suggestion);
    }

    @Override
    public List<Suggestions> getAllSuggestions() {
        return suggestionsRepository.findAll();
    }


    @Override
    public Suggestions markAsRead(String suggestionId) {
        Optional<Suggestions> existing = suggestionsRepository.findById(suggestionId);
        if (existing.isPresent()) {
            Suggestions suggestion = existing.get();
            suggestion.setStatus("READ");
            return suggestionsRepository.save(suggestion);
        } else {
            throw new RuntimeException("Suggestion not found with id: " + suggestionId);
        }
    }

}
