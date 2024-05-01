package com.ich.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ich.template.dao.FormulariosDAO;
import com.ich.template.dto.FormulariosDto;
import com.ich.template.exception.BadRequestException;
import com.ich.template.model.Formularios;
import com.ich.template.utility.Mapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FormulariosService {



    @Autowired
    private FormulariosDAO formulariosDao;
    
    @Autowired
    private Mapper mapper;
	
	
    public List<Formularios> findAll() {
        List<Formularios> formularioss= (List<Formularios>) formulariosDao.findAll();
        return formularioss;
    }

    public FormulariosDto get(Long id) {
		if (!formulariosDao.existsById(id))
			throw new BadRequestException("404", "Not found");
		
    	Formularios formularios = formulariosDao.findById(id).get();
    	
    	return (FormulariosDto) mapper.map( formularios,FormulariosDto.class);
    }

    public FormulariosDto save(FormulariosDto formulariosDto) {
    	
    	if(formulariosDto.getId() != 0)
    		formulariosDto.setId(0);
    	
    	Formularios formularios = new Formularios();
    	
    /*	formularios.setName (formulariosDto.getName());
    	formularios.setData (formulariosDto.getData());*/
    	
    	formularios = (Formularios) mapper.map( formulariosDto,Formularios.class);
    	
    	formulariosDao.save(formularios);
    	formulariosDto.setId(formularios.getId());
    	
    	return formulariosDto;
    }
    
    public FormulariosDto modify(FormulariosDto formulariosDto) {
    	
		if (!formulariosDao.existsById( Long.valueOf(formulariosDto.getId()) ))
			throw new BadRequestException("404", "Not found");
    	Formularios formularios = new Formularios();
/*    	formularios.setId(formulariosDto.getId());
    	formularios.setName (formulariosDto.getName());
    	formularios.setData (formulariosDto.getData());*/
    	
    	formularios = (Formularios) mapper.map( formulariosDto,Formularios.class);
    	
    	formulariosDao.save(formularios);
    	formulariosDto.setId(formularios.getId());
    	
    	return formulariosDto;
    }

    public void delete(Long id) {
		if (!formulariosDao.existsById(id))
			throw new BadRequestException("404", "Not found");
    	formulariosDao.deleteById(id);
    }

}
