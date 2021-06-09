package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.PrewritingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PrewritingDao;

import kodlamaio.hrms.entities.concretes.Prewriting;

public class PrewritingManager implements PrewritingService{
	private PrewritingDao prewritingDao;
	@Autowired
	public PrewritingManager(PrewritingDao prewritingDao) {
		super();
		this.prewritingDao = prewritingDao;
	}

	@Override
	public Result add(Prewriting prewriting) {
		this.prewritingDao.save(prewriting);
		return new SuccessResult("Önyazı eklendi.");
	}

	@Override
	public DataResult<List<Prewriting>> getByCandidateId(int candidateId) {
		var result = this.prewritingDao.getByCandidateId(candidateId);
		if (result != null) {
			return new SuccessDataResult<List<Prewriting>>("Data listelendi");
		}
		return new ErrorDataResult<List<Prewriting>>("Data listelenemedi");
	}
	

}
