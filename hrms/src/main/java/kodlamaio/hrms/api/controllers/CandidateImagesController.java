package kodlamaio.hrms.api.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;

@RestController
@RequestMapping("/api/candidateImages")

public class CandidateImagesController {
	private CandidateImageService candidateImageService;
	private CandidateService candidateService;
	@Autowired
	public CandidateImagesController(CandidateImageService candidateImageService, CandidateService candidateService) {
		super();
		this.candidateImageService = candidateImageService;
		this.candidateService = candidateService;
	}

	
	
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateImage>>getAll(){
		return this.candidateImageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<CandidateImage>getById(int id){
		return this.candidateImageService.getById(id);
	}
	
	@PostMapping(value = "/add")
	public Result add(@Valid @RequestParam(value = "id") int id, @RequestParam(value = "file") MultipartFile file){
		Candidate candidate = this.candidateService.getById(id).getData();
		CandidateImage candidateImage = new CandidateImage();
		candidateImage.setCandidate(candidate);
		return this.candidateImageService.add(file,candidateImage);
		
	}

}
