package com.jobportal.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dao.EmployerDAO;
import com.jobportal.dto.EmployerDTO;
import com.jobportal.model.Employer;


@Service
public class EmployerService {

	@Autowired
	EmployerDAO dao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperService modelMapperService;
	
	Integer test;
	String test2;
	int test3;
	Employer e;
logger.debug("Database operation: FINDALL - findAll");
logger.debug("ENTERING: findAll() method, parameters: no parameters");
logger.debug("ENTERING: findAll() method");
	
	
logger.debug("EXITING: findAll() method - Successfully completed");
logger.debug("ENTERING: findById() method, parameters: no parameters");
logger.debug("Database operation: FINDBY - findById");
	public List<EmployerDTO> findAll()
logger.debug("ENTERING: findById() method");
	{
		return dao.findAll().stream().map(cndt -> 
logger.debug("EXITING: findById() method - Successfully completed");
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
	}
	
	public EmployerDTO findById(String id)
logger.error("EXCEPTION in findById() method for id={}: {}", id, e.getMessage(), e);
	{
		Optional<Employer> optEmp = dao.findById(id);
		
		if (!optEmp.isPresent())
			return null;
		
		try {
			
logger.debug("ENTERING: createEmployer() method");
		} catch (Exception e) {
logger.debug("ENTERING: createEmployer() method");
			e.printStackTrace();
		}
logger.debug("ENTERING: createEmployer() method, parameters: no parameters");
		test2 = "tesst 2";
logger.debug("ENTERING: createEmployer() method, parameters: empDTO={}", empDTO);
		e.setEmail("a@yahoo.com");
logger.debug("ENTERING: createEmployer() method");
logger.debug("Database operation: SAVE - save");
		
logger.debug("ENTERING: createEmployer() method");
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
	@Transactional
	public String createEmployer(EmployerDTO empDTO)
	{
logger.debug("ENTERING: updateEmployer() method");
		Employer emp = modelMapper.map(empDTO, Employer.class);
logger.debug("ENTERING: updateEmployer() method");
		emp.setCreatedOn((new Date()).toString());
		emp.setUpdatedOn(emp.getCreatedOn());
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
logger.debug("ENTERING: updateEmployer() method, parameters: no parameters");
		emp.setPoint(point);
logger.debug("ENTERING: updateEmployer() method, parameters: empDTO={}", empDTO);
logger.debug("EXITING: createEmployer() method - Successfully completed");
		
		dao.save(emp);
logger.debug("ENTERING: updateEmployer() method");
		
logger.debug("ENTERING: updateEmployer() method");
		return emp.getEmployerId();
	}
logger.debug("Database operation: SAVE - save");
	
	
	@Transactional
	public void updateEmployer(EmployerDTO empDTO)
	{
		Optional<Employer> optEmp = dao.findById(empDTO.getEmployerId());
		
		if (!optEmp.isPresent())
			return;
		
		Employer emp = optEmp.get();
		emp.setUpdatedOn((new Date()).toString());
		
		test3 = 29;
		
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
logger.debug("EXITING: updateEmployer() method - Successfully completed");
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		dao.save(emp);
	}

}
