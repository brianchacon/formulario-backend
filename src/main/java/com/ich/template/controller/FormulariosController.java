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

import com.ich.template.dto.FormulariosDto;
import com.ich.template.dto.ResponseStatus;
import com.ich.template.exception.BadRequestException;
import com.ich.template.service.FormulariosService;

@RestController
@RequestMapping("/formularios")
public class FormulariosController {

	@Autowired
	private FormulariosService formulariosService;
	
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<Object>(formulariosService.findAll(), HttpStatus.OK);
    }
    
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/id/{formulariosId}", produces = "application/json")
    public ResponseEntity<?> getFormularios(@PathVariable Long formulariosId){
		 
		try {
			return new ResponseEntity<Object>(formulariosService.get(formulariosId), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody FormulariosDto formulariosDto){
		 return new ResponseEntity<Object>(formulariosService.save(formulariosDto), HttpStatus.OK);		 
    }
	
	@PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity<?> modify(@RequestBody FormulariosDto formulariosDto){
		 
		try {
			return new ResponseEntity<Object>(formulariosService.modify(formulariosDto), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/delete/{formulariosId}", produces = "application/json")
    public ResponseEntity<?> deleteFormularios(@PathVariable Long formulariosId){
		 
		try {
			formulariosService.delete(formulariosId);
			return new ResponseEntity<Object>(null, HttpStatus.OK) ;
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
}
