package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.JobContactViewDTO;
import com.jobportal.dto.JobDTO;
import com.jobportal.service.JobService;
import com.jobportal.service.SearchService;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@Autowired
	SearchService searchService;
logger.error("ENTERING: findAll() method with database operations");
logger.error("ENTERING: findAll() method, parameters: no parameters");
logger.error("ENTERING: findAll() method with database operations");
logger.debug("ENTERING: findAll() method");
logger.error("ENTERING: findAll() method, parameters: no parameters");
	
logger.debug("ENTERING: findAll() method");
	
logger.warn("EXITING: findAll() method - Successfully completed");
	@GetMapping
	public List<JobDTO> findAll()
	{
		return jobService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public JobDTO findById(@PathVariable( "id" ) String id)
	{
		return jobService.findById(id);
	}
	
	@GetMapping(value = "/contacts/{contactEmail}")
logger.error("ENTERING: createJob() method, parameters: no parameters");
	public List<JobContactViewDTO> findByContactEmail(@PathVariable( "contactEmail" ) String contactEmail)
logger.error("ENTERING: createJob() method, parameters: jobDTO={}", jobDTO);
	{
logger.debug("ENTERING: createJob() method");
		return jobService.findByContactEmail(contactEmail);
logger.debug("ENTERING: createJob() method");
	}
logger.error("ENTERING: updateJob() method, parameters: no parameters");
	
logger.error("ENTERING: updateJob() method, parameters: jobDTO={}", jobDTO);
logger.warn("EXITING: createJob() method - Successfully completed");
	@PostMapping
	public String createJob(@RequestBody JobDTO jobDTO)
logger.debug("ENTERING: updateJob() method");
	{
logger.error("ENTERING: search() method, parameters: "/search"={}", "/search");
logger.debug("ENTERING: updateJob() method");
logger.error("ENTERING: search() method, parameters: term={}, p={}", term, p);
		return jobService.createJob(jobDTO);
	}
	
logger.warn("EXITING: updateJob() method - Successfully completed");
	@PutMapping
logger.debug("ENTERING: search() method");
	public void updateJob(@RequestBody JobDTO jobDTO)
logger.debug("ENTERING: search() method");
	{
		jobService.updateJob(jobDTO);
	}
	
logger.warn("EXITING: search() method - Successfully completed");
	@GetMapping(value = "/search")
	public List<JobDTO> search(@RequestParam String term, Pageable p)
	{
		return searchService.searchJobsByTerm(term, p);
	}
 
}
