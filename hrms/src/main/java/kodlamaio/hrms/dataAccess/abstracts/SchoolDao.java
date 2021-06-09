package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.School;

@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {
	List<School> getByCandidateId(Sort sort, int candidateId);

}
