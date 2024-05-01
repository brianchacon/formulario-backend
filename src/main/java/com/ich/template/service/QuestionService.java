package com.ich.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ich.template.dao.QuestionDAO;
import com.ich.template.dto.QuestionDto;
import com.ich.template.exception.BadRequestException;
import com.ich.template.model.Question;
import com.ich.template.utility.Mapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionService {



    @Autowired
    private QuestionDAO questionDao;
    
    @Autowired
    private Mapper mapper;
	
	
    public List<Question> findAll() {
        List<Question> questions= (List<Question>) questionDao.findAll();
        return questions;
    }

    public QuestionDto get(Long id) {
		if (!questionDao.existsById(id))
			throw new BadRequestException("404", "Not found");
		
    	Question question = questionDao.findById(id).get();
    	
    	return (QuestionDto) mapper.map( question,QuestionDto.class);
    }

    public QuestionDto save(QuestionDto questionDto) {
    	
    	if(questionDto.getId() != 0)
    		questionDto.setId(0);
    	
    	Question question = new Question();
    	
    /*	question.setName (questionDto.getName());
    	question.setData (questionDto.getData());*/
    	
    	question = (Question) mapper.map( questionDto,Question.class);
    	
    	questionDao.save(question);
    	questionDto.setId(question.getId());
    	
    	return questionDto;
    }
    
    public QuestionDto modify(QuestionDto questionDto) {
    	
		if (!questionDao.existsById( Long.valueOf(questionDto.getId()) ))
			throw new BadRequestException("404", "Not found");
    	Question question = new Question();
/*    	question.setId(questionDto.getId());
    	question.setName (questionDto.getName());
    	question.setData (questionDto.getData());*/
    	
    	question = (Question) mapper.map( questionDto,Question.class);
    	
    	questionDao.save(question);
    	questionDto.setId(question.getId());
    	
    	return questionDto;
    }

    public void delete(Long id) {
		if (!questionDao.existsById(id))
			throw new BadRequestException("404", "Not found");
    	questionDao.deleteById(id);
    }

}