package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService=jobAdvertisementService;
	}
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>>getByIsActiveTrue(int pageNo,int pageSize){
		return this.jobAdvertisementService.getByIsActiveTrue(pageNo, pageSize);
	}
	@GetMapping("/getByIsActiveTrueOrderByReleaseDate")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDate(int pageNo,int pageSize){
		return this.jobAdvertisementService.getByIsActiveTrue(pageNo, pageSize);
	}
	@GetMapping("/getByIsActiveTrueAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName,int pageNo,int pageSize){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName, pageNo, pageSize);
	}
	@PostMapping(value="/add")
	public Result add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@PostMapping("/setIsActive")
	public Result setIsActive(int jobAdvertisementId, boolean isActive) {
		return this.jobAdvertisementService.setIsActive( jobAdvertisementId,isActive);
	}
	
}
