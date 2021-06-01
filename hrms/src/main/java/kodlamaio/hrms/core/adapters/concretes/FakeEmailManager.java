package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeEmailService;

@Service
public class FakeEmailManager implements FakeEmailService {

	@Override
	public boolean isMailValidation(String email) {
		System.out.println(email+ "mail adresi için doğrulama başarılı!");
		return true;
	}

}