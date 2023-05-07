package com.student.survey.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class SurveyForm {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String telephone;
    private String email;
    private String surveyDate;
    @ElementCollection
    private List<String> campusLikes;
    private String interestedIn;
    private String recommendation;
    private String comments;
}
