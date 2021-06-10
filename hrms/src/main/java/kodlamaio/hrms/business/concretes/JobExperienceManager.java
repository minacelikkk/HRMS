package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager  implements JobExperienceService{
	private JobExperienceDao jobExperienceDao;

@Autowired
public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}



@Override
public Result add(JobExperience jobExperience) {
	this.jobExperienceDao.save(jobExperience);
	return new SuccessResult("Isciler listelendi.");
}



@Override
public DataResult<List<JobExperience>> getAll() {
	return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"İş tecrübelerinin tümü getirildi.");
}



@Override
public DataResult<List<JobExperience>> getByCandidateIdOrderByDateOfEndDESC(int candidateId) {
	Sort sortBy = Sort.by(Sort.Direction.DESC,"dateOfEnd");
	
	var result = this.jobExperienceDao.getByCandidateId(sortBy,candidateId);
	if(result != null){
		return new SuccessDataResult<List<JobExperience>>(result,"Tecrübeler yıla göre ters listelendi.");
		}
	return new ErrorDataResult<List<JobExperience>>("Tecrübeler yıla göre ters listelenemedi.");
}
}