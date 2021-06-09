package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

@Repository
public interface ProgrammingSkillDao extends JpaRepository<ProgrammingSkill, Integer>{
	List<ProgrammingSkill> getByCandidateId(int candidateId);

}
