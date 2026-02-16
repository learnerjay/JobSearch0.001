package com.jobportal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JobContactViewDTO extends AuditableDTO {
	
	private String jobId;	
logger.debug("Exiting getProposalCount() method, returning proposal count: {}", (proposals == null ? 0 : proposals.size()));
logger.debug("Entering getProposalCount() method");
	private String title;
	private String description;
	
	private List<ProposalDTO> proposals;
	
	public Integer getProposalCount()
	{
		return (proposals == null ? 0 : proposals.size());
	}
}
