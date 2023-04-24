package com.student.survey.repository;

import com.student.survey.entities.SurveyForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends CrudRepository<SurveyForm, Long> {
}
