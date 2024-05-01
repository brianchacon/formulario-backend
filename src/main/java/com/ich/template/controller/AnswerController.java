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

import com.ich.template.dto.AnswerDto;
import com.ich.template.dto.ResponseStatus;
import com.ich.template.exception.BadRequestException;
import com.ich.template.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<Object>(answerService.findAll(), HttpStatus.OK);
    }
    
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/id/{answerId}", produces = "application/json")
    public ResponseEntity<?> getAnswer(@PathVariable Long answerId){
		 
		try {
			return new ResponseEntity<Object>(answerService.get(answerId), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody AnswerDto answerDto){
		 return new ResponseEntity<Object>(answerService.save(answerDto), HttpStatus.OK);		 
    }
	
	@PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity<?> modify(@RequestBody AnswerDto answerDto){
		 
		try {
			return new ResponseEntity<Object>(answerService.modify(answerDto), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/delete/{answerId}", produces = "application/json")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long answerId){
		 
		try {
			answerService.delete(answerId);
			return new ResponseEntity<Object>(null, HttpStatus.OK) ;
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
}
