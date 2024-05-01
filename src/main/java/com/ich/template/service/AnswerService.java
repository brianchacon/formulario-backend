package com.ich.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ich.template.dao.AnswerDAO;
import com.ich.template.dto.AnswerDto;
import com.ich.template.exception.BadRequestException;
import com.ich.template.model.Answer;
import com.ich.template.utility.Mapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AnswerService {


    @Autowired
    private AnswerDAO answerDao;
    
    @Autowired
    private Mapper mapper;
	
	
    public List<Answer> findAll() {
        List<Answer> answers= (List<Answer>) answerDao.findAll();
        return answers;
    }

    public AnswerDto get(Long id) {
		if (!answerDao.existsById(id))
			throw new BadRequestException("404", "Not found");
		
    	Answer answer = answerDao.findById(id).get();
    	
    	return (AnswerDto) mapper.map( answer,AnswerDto.class);
    }

    public AnswerDto save(AnswerDto answerDto) {
    	
    	if(answerDto.getId() != 0)
    		answerDto.setId(0);
    	
    	Answer answer = new Answer();
    	
    /*	answer.setName (answerDto.getName());
    	answer.setData (answerDto.getData());*/
    	
    	answer = (Answer) mapper.map( answerDto,Answer.class);
    	
    	answerDao.save(answer);
    	answerDto.setId(answer.getId());
    	
    	return answerDto;
    }
    
    public AnswerDto modify(AnswerDto answerDto) {
    	
		if (!answerDao.existsById( Long.valueOf(answerDto.getId()) ))
			throw new BadRequestException("404", "Not found");
    	Answer answer = new Answer();
/*    	answer.setId(answerDto.getId());
    	answer.setName (answerDto.getName());
    	answer.setData (answerDto.getData());*/
    	
    	answer = (Answer) mapper.map( answerDto,Answer.class);
    	
    	answerDao.save(answer);
    	answerDto.setId(answer.getId());
    	
    	return answerDto;
    }

    public void delete(Long id) {
		if (!answerDao.existsById(id))
			throw new BadRequestException("404", "Not found");
    	answerDao.deleteById(id);
    }

}
