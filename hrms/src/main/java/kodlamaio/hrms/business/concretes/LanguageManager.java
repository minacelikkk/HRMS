package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;


public class LanguageManager  implements LanguageService{
	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}
	@Override
	public Result add(Language language) {
		if(language.getLevel()==1||language.getLevel()==2||language.getLevel()==3
				||language.getLevel()==4||language.getLevel()==5) {
			
			return new SuccessResult("Yabancı dil eklendi.");
			}
		else {
			return new ErrorResult("Yabancı dil eklenemedi.Lütfen 1-5 arasında seviye seçiniz.");
		}
	}
	@Override
	public DataResult<List<Language>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByCandidateId(candidateId));
	}
	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}
	
	

		
}