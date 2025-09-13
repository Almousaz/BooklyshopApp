package com.developeWtihAli.BooklyshopApp.bookSuggestions.controller;


import com.developeWtihAli.BooklyshopApp.bookSuggestions.entity.Suggestions;
import com.developeWtihAli.BooklyshopApp.bookSuggestions.service.SuggestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/suggestions")
@CrossOrigin
public class SuggestionsController {


    @Autowired
    private SuggestionsService suggestionsService;

    // Create suggestion
    @PostMapping("/create")
    public ResponseEntity<?> addSuggestion(@RequestBody Suggestions suggestion) {
        try {
            Suggestions savedSuggestion = suggestionsService.addSuggestion(suggestion);
            return ResponseEntity.ok(savedSuggestion);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to create suggestion: " + e.getMessage());
        }
    }

    // Get all suggestions
    @GetMapping("/all")
    public ResponseEntity<List<Suggestions>> getAllSuggestions() {
        return ResponseEntity.ok(suggestionsService.getAllSuggestions());
    }

    // Mark suggestion as read
    @PutMapping("/markread/{id}")
    public ResponseEntity<?> markSuggestionAsRead(@PathVariable String id) {
        try {
            Suggestions updatedSuggestion = suggestionsService.markAsRead(id);
            return ResponseEntity.ok(updatedSuggestion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
