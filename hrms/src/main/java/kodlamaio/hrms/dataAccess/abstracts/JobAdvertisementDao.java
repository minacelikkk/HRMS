package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

	JobAdvertisement getById(int JobAdvertisementId);
	List<JobAdvertisement>getByIsActiveTrue(Pageable pageable);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByReleaseDate(Pageable pageable);
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName, Pageable pageable);
}
