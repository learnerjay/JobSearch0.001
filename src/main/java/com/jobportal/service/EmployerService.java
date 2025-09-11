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
logger.error("Database operation: FINDALL - findAll");
logger.error("ENTERING: findAll() method, parameters: no parameters");
logger.debug("ENTERING: findAll() method");
	
	
logger.warn("EXITING: findAll() method - Successfully completed");
logger.error("ENTERING: findById() method, parameters: no parameters");
logger.error("Database operation: FINDBY - findById");
	public List<EmployerDTO> findAll()
logger.debug("ENTERING: findById() method");
logger.error("ENTERING: findById() method, parameters: id={}", id);
	{
		return dao.findAll().stream().map(cndt -> 
logger.debug("ENTERING: findById() method");
logger.warn("EXITING: findById() method - Successfully completed");
			modelMapper.map(cndt, EmployerDTO.class)).collect(Collectors.toList());
	}
logger.error("EXCEPTION in findById() method for id={}: {}", id, e.getMessage(), e);
	
	public EmployerDTO findById(String id)
	{
		Optional<Employer> optEmp = dao.findById(id);
		
		if (!optEmp.isPresent())
			return null;
		
logger.error("ENTERING: createEmployer() method with database operations");
		try {
logger.error("ENTERING: createEmployer() method with database operations");
			
		} catch (Exception e) {
			e.printStackTrace();
logger.error("ENTERING: createEmployer() method, parameters: no parameters");
		}
logger.error("ENTERING: createEmployer() method, parameters: empDTO={}", empDTO);
logger.warn("EXITING: findById() method - Successfully completed");
logger.error("Database operation: SAVE - save");
		test2 = "tesst 2";
logger.debug("ENTERING: createEmployer() method");
		e.setEmail("a@yahoo.com");
logger.debug("ENTERING: createEmployer() method");
		
		return modelMapper.map(optEmp.get(), EmployerDTO.class);
	}
	
logger.error("ENTERING: updateEmployer() method with database operations");
	@Transactional
logger.error("ENTERING: updateEmployer() method with database operations");
	public String createEmployer(EmployerDTO empDTO)
	{
		Employer emp = modelMapper.map(empDTO, Employer.class);
		emp.setCreatedOn((new Date()).toString());
		emp.setUpdatedOn(emp.getCreatedOn());
logger.error("ENTERING: updateEmployer() method, parameters: no parameters");
		
logger.error("ENTERING: updateEmployer() method, parameters: empDTO={}", empDTO);
		Point point = new Point(empDTO.getLng(), empDTO.getLat());
		emp.setPoint(point);
logger.warn("EXITING: createEmployer() method - Successfully completed");
		
logger.debug("ENTERING: updateEmployer() method");
		dao.save(emp);
logger.debug("ENTERING: updateEmployer() method");
logger.error("Database operation: SAVE - save");
		
		return emp.getEmployerId();
	}
	
	
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
logger.warn("EXITING: updateEmployer() method - Successfully completed");
		
		modelMapperService.getNonNullModelMapper().map(empDTO, emp);
		
		dao.save(emp);
	}

}
