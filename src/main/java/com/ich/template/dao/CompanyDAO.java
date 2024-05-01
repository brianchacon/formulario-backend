package com.ich.template.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ich.template.model.Company;


public interface CompanyDAO extends CrudRepository<Company,Long>,PagingAndSortingRepository<Company, Long>{

}
