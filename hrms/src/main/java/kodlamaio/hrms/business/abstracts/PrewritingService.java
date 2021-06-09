package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Prewriting;

public interface PrewritingService {
	Result add(Prewriting prewriting);
	DataResult<List<Prewriting>> getByCandidateId(int candidateId);
	

}
