package com.ich.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ich.template.dao.CompanyDAO;
import com.ich.template.dto.CompanyDto;
import com.ich.template.exception.BadRequestException;
import com.ich.template.model.Company;
import com.ich.template.utility.Mapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompanyService {


    @Autowired
    private CompanyDAO companyDao;
    
    @Autowired
    private Mapper mapper;
	
	
    public List<Company> findAll() {
        List<Company> companys= (List<Company>) companyDao.findAll();
        return companys;
    }

    public CompanyDto get(Long id) {
		if (!companyDao.existsById(id))
			throw new BadRequestException("404", "Not found");
		
    	Company company = companyDao.findById(id).get();
    	
    	return (CompanyDto) mapper.map( company,CompanyDto.class);
    }

    public CompanyDto save(CompanyDto companyDto) {
    	
    	if(companyDto.getId() != 0)
    		companyDto.setId(0);
    	
    	Company company = new Company();
    	
    /*	company.setName (companyDto.getName());
    	company.setData (companyDto.getData());*/
    	
    	company = (Company) mapper.map( companyDto,Company.class);
    	
    	companyDao.save(company);
    	companyDto.setId(company.getId());
    	
    	return companyDto;
    }
    
    public CompanyDto modify(CompanyDto companyDto) {
    	
		if (!companyDao.existsById( Long.valueOf(companyDto.getId()) ))
			throw new BadRequestException("404", "Not found");
    	Company company = new Company();
/*    	company.setId(companyDto.getId());
    	company.setName (companyDto.getName());
    	company.setData (companyDto.getData());*/
    	
    	company = (Company) mapper.map( companyDto,Company.class);
    	
    	companyDao.save(company);
    	companyDto.setId(company.getId());
    	
    	return companyDto;
    }

    public void delete(Long id) {
		if (!companyDao.existsById(id))
			throw new BadRequestException("404", "Not found");
    	companyDao.deleteById(id);
    }

}
