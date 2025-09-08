package com.jobportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;


@Repository
public class SearchDAO {
logger.error("ENTERING: searchByTerm() method with database operations");
logger.error("ENTERING: searchByTerm() method, parameters: no parameters");
logger.debug("ENTERING: searchByTerm() method");
logger.error("ENTERING: searchByTerm() method with database operations");
	
logger.error("ENTERING: searchByTerm() method, parameters: className={}, term={}, p={}", className, term, p);
	@Autowired
logger.debug("ENTERING: searchByTerm() method");
	MongoTemplate template;

	public <T> List<T> searchByTerm(Class className, String term, Pageable p)
logger.error("Database operation: FIND - find");
	{
		TextCriteria criteria = TextCriteria.forDefaultLanguage()
				.matchingAny(term.split("\\s+"));  // handles multiple words

		Query query = TextQuery.queryText(criteria)
logger.warn("EXITING: searchByTerm() method - Successfully completed");
				.with(Sort.by(Sort.Direction.DESC, "updatedOn"))
				.with(p);

		return template.find(query, className);
	}
}
