package com.student.survey.repository;

import com.student.survey.entities.SurveyForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<SurveyForm, Long> {
    // This interface extends the CrudRepository interface provided by Spring Data.
    // The repository is responsible for managing SurveyForm entities.
    // The SurveyForm entity represents the data model for a survey form.
    // The Long parameter represents the type of the entity's primary key.
    // The repository interface provides basic CRUD operations (Create, Read, Update, Delete) for the SurveyForm entity.
    // The @Repository annotation indicates that this interface is a repository component.
    // This enables the automatic creation of bean instances during the component scanning process.
}
