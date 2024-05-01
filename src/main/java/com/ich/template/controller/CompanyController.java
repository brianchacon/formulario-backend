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

import com.ich.template.dto.CompanyDto;
import com.ich.template.dto.ResponseStatus;
import com.ich.template.exception.BadRequestException;
import com.ich.template.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<Object>(companyService.findAll(), HttpStatus.OK);
    }
    
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/id/{companyId}", produces = "application/json")
    public ResponseEntity<?> getCompany(@PathVariable Long companyId){
		 
		try {
			return new ResponseEntity<Object>(companyService.get(companyId), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody CompanyDto companyDto){
		 return new ResponseEntity<Object>(companyService.save(companyDto), HttpStatus.OK);		 
    }
	
	@PostMapping(value = "/update", produces = "application/json")
    public ResponseEntity<?> modify(@RequestBody CompanyDto companyDto){
		 
		try {
			return new ResponseEntity<Object>(companyService.modify(companyDto), HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/delete/{companyId}", produces = "application/json")
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyId){
		 
		try {
			companyService.delete(companyId);
			return new ResponseEntity<Object>(null, HttpStatus.OK) ;
		} catch (BadRequestException e) {
			return new ResponseEntity<Object>(new ResponseStatus(e.getCodigo(), e.getMensaje()),
					HttpStatus.BAD_REQUEST);			
		}
    }
}
