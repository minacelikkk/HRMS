package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Prewriting;

@Repository
public interface PrewritingDao extends JpaRepository<Prewriting, Integer>{
	List<Prewriting> getByCandidateId(int candidateId);

}
