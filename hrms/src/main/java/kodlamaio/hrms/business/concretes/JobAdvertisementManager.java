package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager  implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private JobTitleDao jobTitleDao;
	private CityDao cityDao;
		
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao,
			JobTitleDao jobTitleDao, CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.jobTitleDao = jobTitleDao;
		this.cityDao = cityDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getEmployer()==null||jobAdvertisement.getDescription()==null||jobAdvertisement.getApplicationDeadline()==null
				||jobAdvertisement.getCity()==null||jobAdvertisement.getOpenPositions()==null) {
			return new ErrorResult("Tum alanlari doldurunuz.");
		}
		else if(employerDao.findById(jobAdvertisement.getEmployer().getId())==null) {
			return new  ErrorResult("Kullanici bulunamadi.");
		}
		else if(jobTitleDao.findById(jobAdvertisement.getJobTitle().getId())==null) {
			return new  ErrorResult("Is pozisyonu  bulunamadi.");
		}
		else if(cityDao.findById(jobAdvertisement.getCity().getId())==null) {
			return new  ErrorResult("Sehir  bulunamadi.");
		}
		else {
			jobAdvertisement.setActive(true);
			jobAdvertisement.setReleaseDate(LocalDate.now());
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Is ilanı basarili bir sekilde eklendi.");}
		}
		@Override
		public Result setIsActive(int jobAdvertisementId,boolean isActive) {
			JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(jobAdvertisementId);
			jobAdvertisement.setActive(isActive);
			this.jobAdvertisementDao.save(jobAdvertisement);
			return (isActive==false 
					? 
						new SuccessResult("İş ilanı pasif yapıldı") 
					: 
						new SuccessResult("İş ilanı aktif yapıldı"));
			
		}

		@Override
		public DataResult<List<JobAdvertisement>> getByIsActiveTrue(int pageNo, int pageSize) {
			Pageable pageable = (Pageable) PageRequest.of(pageNo-1, pageSize);
			
			return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.getByIsActiveTrue(pageable), "Data listelendi");
		}

		@Override
		public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDate(int pageNo, int pageSize) {
			Pageable pageable = (Pageable) PageRequest.of(pageNo-1, pageSize);
			
			return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDate(pageable), "Data listelendi");
		}

		@Override
		public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName,
				int pageNo, int pageSize) {
			Pageable pageable = (Pageable) PageRequest.of(pageNo-1, pageSize);
			
			return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName, pageable), "Data listelendi");
		}

		@Override
		public DataResult<List<JobAdvertisement>> getById(int jobAdvertisementId) {
			var result = this.jobAdvertisementDao.getById(jobAdvertisementId);
			if (result != null) {
				return new SuccessDataResult<List<JobAdvertisement>>("Data listelendi");
			}
			return new ErrorDataResult<List<JobAdvertisement>>("Data listelenemedi");
		}

		
	}
	

	