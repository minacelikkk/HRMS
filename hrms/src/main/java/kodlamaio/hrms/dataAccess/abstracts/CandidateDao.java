package kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;


public interface CandidateDao  extends JpaRepository<Candidate, Integer>{
	
		
	Candidate getByEmailEquals(String getEmail);
	
	Candidate getByIdentityNumberEquals(String getIdentityNumber);
	
	
	

}
