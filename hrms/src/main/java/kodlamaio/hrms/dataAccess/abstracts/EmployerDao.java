package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	Employer getByEmail(String getEmail);
	
	Employer getByPhoneNumber(int PhoneNumber);
	
	Employer getByWebAddress(String WebAdress);
	
	

}
