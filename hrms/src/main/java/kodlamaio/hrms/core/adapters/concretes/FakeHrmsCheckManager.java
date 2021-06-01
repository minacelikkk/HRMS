package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.FakeHrmsCheckService;

@Service
public class FakeHrmsCheckManager implements FakeHrmsCheckService {
	@Override 
	public boolean confirmUser() {
		return true;
	}

}
