package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.abstracts.FakeEmailService;
import kodlamaio.hrms.core.adapters.abstracts.FakeHrmsCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;

import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private FakeEmailService fakeEmailService;
	private FakeHrmsCheckService fakeHrmsCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,FakeEmailService fakeEmailService,FakeHrmsCheckService fakeHrmsCheckService) {
		super();
		this.employerDao=employerDao;
		this.fakeHrmsCheckService=fakeHrmsCheckService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		String[] domain = employer.getEmail().split("@");
		String website=employer.getWebAddress().substring(4);

		if (employer.getCompanyName() == null || employer.getWebAddress() == null
				|| employer.getPhoneNumber() == null || employer.getEmail() == null
				|| employer.getPassword() == null) {
			return new ErrorResult("Herhangi bir alan boş geçilemez");
		} else

		if (!domain[1].equals(website)) {
			return new ErrorResult("e-posta ve web sitesi uyusmuyor.");
		} else

		if (employerDao.getByEmail(employer.getEmail()) != null)
		{
			return new ErrorResult("Bu e posta zaten kullaniliyor");
		} 

		if (!fakeEmailService.isMailValidation(employer.getEmail())) {
			return new ErrorResult("Mail dogrulamasi gerceklesmedi. ");}
		if (!fakeEmailService.isMailValidation(employer.getEmail())) {
			return new ErrorResult("Mail dogrulamasi gerceklesmedi. Kayit basarisiz");
		} else if (!fakeHrmsCheckService.confirmUser()) {
			return new ErrorResult("Kayit dogrulanmadi. Islem basarisiz!");
			} 
		else {
			employerDao.save(employer);
			return new SuccessResult("Kayit Basarili bir sekilde olusturuldu");
			}
		
			

	}
}

