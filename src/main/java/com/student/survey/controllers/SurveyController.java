package com.student.survey.controllers;

import com.student.survey.entities.SurveyForm;
import com.student.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class SurveyController {
    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    // Allow cross-origin requests for the "/survey-form" endpoint
    @CrossOrigin
    @PostMapping("/survey-form")
    public ResponseEntity<String> submitForm(@RequestBody SurveyForm form) {
        // Save the submitted form using the surveyRepository
        surveyRepository.save(form);
        // Return a response indicating the form submission was successful
        return ResponseEntity.ok("Form submitted successfully");
    }

    // Allow cross-origin requests for the "/survey-form" endpoint
    @CrossOrigin
    @GetMapping("/survey-form")
    public ResponseEntity<List<SurveyForm>> getAllSurveyForms() {
        // Retrieve all survey forms from the surveyRepository
        Iterable<SurveyForm> all = surveyRepository.findAll();
        // Convert the Iterable to a List using Java 8 Stream API
        List<SurveyForm> collect = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
        // Return a response containing the list of survey forms
        return ResponseEntity.ok(collect);
    }
}
