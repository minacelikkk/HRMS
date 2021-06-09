package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobTitle;

@Repository
public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	
	JobTitle getByJobTitle(String JobTitle);
	
	

}
