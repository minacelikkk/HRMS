package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Link;

@Repository
public interface LinkDao extends JpaRepository<Link,Integer>{

	List<Link> getByCandidateId(int candidateId);
}
