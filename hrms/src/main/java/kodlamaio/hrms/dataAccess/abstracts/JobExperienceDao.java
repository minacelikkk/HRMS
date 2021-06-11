package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobExperience;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	

	List<JobExperience> getByCandidateId(Sort sort, int candidateId);

}
