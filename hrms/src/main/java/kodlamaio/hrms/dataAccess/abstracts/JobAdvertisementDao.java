package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

	JobAdvertisement getById(int jobAdvertisementId);
	List<JobAdvertisement>getByIsActiveTrue(Pageable pageable);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByReleaseDate(Pageable pageable);
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName, Pageable pageable);
}
