package com.ich.template.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ich.template.model.Question;

public interface QuestionDAO extends CrudRepository<Question,Long>,PagingAndSortingRepository<Question, Long>{

}
