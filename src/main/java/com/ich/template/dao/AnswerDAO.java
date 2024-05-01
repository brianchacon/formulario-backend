package com.ich.template.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ich.template.model.Answer;


public interface AnswerDAO extends CrudRepository<Answer,Long>,PagingAndSortingRepository<Answer, Long>{
	
	//List<Answer> findByUserAndArticleId(int userId,int articleId);
}
