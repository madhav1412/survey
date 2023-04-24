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

    @PostMapping("/survey-form")
    public ResponseEntity<String> submitForm(@RequestBody SurveyForm form) {
        surveyRepository.save(form);
        return ResponseEntity.ok("Form submitted successfully");
    }

    @GetMapping("/survey-form")
    public ResponseEntity<List<SurveyForm>> getAllSurveyForms() {
        Iterable<SurveyForm> all = surveyRepository.findAll();
        List<SurveyForm> collect = StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }
}
