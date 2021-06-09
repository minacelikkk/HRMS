package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result setIsActive(int jobAdvertisementId, boolean isActive);
	
	DataResult<List<JobAdvertisement>>getByIsActiveTrue(int pageNo,int pageSize);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDate(int pageNo,int pageSize);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName,int pageNo,int pageSize);
	DataResult<List<JobAdvertisement>>getById(int jobAdvertisementId);
	


	

}
