package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	Employer getById(int EmployerId);
	Employer getByEmail(String Email);
	
	Employer getByPhoneNumber(int PhoneNumber);
	
	Employer getByWebAddress(String WebAdress);
	
	

}
