package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.data.domain.Sort;

public class SchoolManager implements SchoolService {
	private SchoolDao schoolDao;
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi");
	}

	@Override
	public DataResult<List<School>> getByCandidateIdOrderByEndedDateDESC(int candidateId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"graduationDate");
		var result = this.schoolDao.getByCandidateId(sortBy,candidateId);
		if (result != null) {
			return new SuccessDataResult<List<School>>(result,"Okullar mezuniyet  yılına göre terstten sıralandı. ");
		}
		return new ErrorDataResult<List<School>>("Okullar mezuniyet  yılına göre terstten sıralanamadı.");
	}
	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okullar eklendi.");
	}

}
