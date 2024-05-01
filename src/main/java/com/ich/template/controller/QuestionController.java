package com.ich.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ich.template.dto.QuestionDto;
import com.ich.template.dto.ResponseStatus;
import com.ich.template.exception.BadRequestException;
import com.ich.template.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<Object>(questionService.findAll(), HttpStatus.OK);
    }
    
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/id/{questionId}", produces = "application/json")
    public ResponseEntity<?> getQuestion(@PathVariable Long questionId){
		 
		try {
			return new ResponseEntity<Object>(questionService.get(questionId), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody QuestionDto questionDto){
		 return new ResponseEntity<Object>(questionService.save(questionDto), HttpStatus.OK);		 
    }
	
	@PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity<?> modify(@RequestBody QuestionDto questionDto){
		 
		try {
			return new ResponseEntity<Object>(questionService.modify(questionDto), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/delete/{questionId}", produces = "application/json")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId){
		 
		try {
			questionService.delete(questionId);
			return new ResponseEntity<Object>(null, HttpStatus.OK) ;
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
}
