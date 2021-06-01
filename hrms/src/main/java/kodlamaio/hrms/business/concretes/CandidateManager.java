package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.FakeEmailService;
import kodlamaio.hrms.core.adapters.abstracts.FakeMernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	private FakeEmailService fakeEmailService;
	private FakeMernisService fakeMernisService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,FakeMernisService fakeMernisService,FakeEmailService fakeEmailService) {
		super();
		this.candidateDao = candidateDao;
		this.fakeMernisService=fakeMernisService;
		this.fakeEmailService=fakeEmailService;
	}

	@Override
	public DataResult<List<Candidate>>getAll(){
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi.");
	}
	@Override
	public Result add(Candidate candidate,String passwordAgain) {
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentityNumber() == null|| candidate.getBirthYear()==null
				|| candidate.getEmail() == null || candidate.getPassword() == null ) {
			return new ErrorResult("Herhangi bir alan boş bırakılamaz ! ");
			
			
		}else if(candidateDao.getByIdentityNumberEquals(candidate.getIdentityNumber())!= null) {
				return new ErrorResult("Kullanilan bir  TCkimlik no  girdiniz!");
				
				
		}else if(candidateDao.getByEmailEquals(candidate.getEmail()) != null) {
			return new ErrorResult("Kullanilan bir email adresi  girdiniz!");
		}else if(!fakeMernisService.checkIfRealPerson(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentityNumber(), candidate.getBirthYear())) {
			return new ErrorResult("Mernis Dogrulamasi basarisiz. Bilgilerinizi  tekrar kontrol ediniz! ");

		}else if(!fakeEmailService.isMailValidation(candidate.getEmail())) {
			return new ErrorResult("Eposta dogrulamasi yapmadiniz. Kaydiniz olusmadi");
		}else if(!Objects.equal(passwordAgain, candidate.getPassword())) {
			return new ErrorResult("Sifreler uyusmuyor.");
			
		}else {
			candidateDao.save(candidate);
			return new SuccessResult("Kayıt başarılı bir şekilde tamamlandı!");
		}

}

}

	
