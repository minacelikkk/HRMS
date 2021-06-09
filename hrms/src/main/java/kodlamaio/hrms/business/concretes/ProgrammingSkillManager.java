package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingSkillDao;

import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

public class ProgrammingSkillManager implements ProgrammingSkillService {
	private ProgrammingSkillDao programmingSkillDao;
	@Autowired
	public ProgrammingSkillManager(ProgrammingSkillDao programmingSkillDao) {
		super();
		this.programmingSkillDao = programmingSkillDao;
	}

	@Override
	public Result add(ProgrammingSkill programmingSkill) {
		this.programmingSkillDao.save(programmingSkill);
		return new SuccessResult("Programlanma becerileri eklendi.");
	
	}

	@Override
	public DataResult<List<ProgrammingSkill>> getByCandidateId(int candidateId) {
			var result = this.programmingSkillDao.getByCandidateId(candidateId);
			if (result != null) {
				return new SuccessDataResult<List<ProgrammingSkill>>("Data listelendi");
			}
			return new ErrorDataResult<List<ProgrammingSkill>>("Data listelenemedi");
	}

	@Override
	public DataResult<List<ProgrammingSkill>> getAll() {
		return new SuccessDataResult<List<ProgrammingSkill>>(this.programmingSkillDao.findAll(),"Data listelendi.");
	}

}
