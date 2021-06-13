package kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.CandidateImage;

@Repository
public interface CandidateImageDao extends JpaRepository<CandidateImage, Integer>{
	
	CandidateImage getByCandidate_Id(int candidateId);
	CandidateImage getById(int id);
	
	
	

}
