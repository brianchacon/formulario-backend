package com.ich.template.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ich.template.model.Formularios;

public interface FormulariosDAO extends CrudRepository<Formularios,Long>,PagingAndSortingRepository<Formularios, Long>{
	
}
