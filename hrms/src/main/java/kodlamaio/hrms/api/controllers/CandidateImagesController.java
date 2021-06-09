package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImage;


@RestController
@RequestMapping("/api/candidateImages")

public class CandidateImagesController {
	private CandidateImageService candidateImageService;
	@Autowired
	public CandidateImagesController(CandidateImageService candidateImageService) {
		super();
		this.candidateImageService = candidateImageService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateImage>> getAll(){
		return this.candidateImageService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CandidateImage candidateImage) {
		return candidateImageService.add(candidateImage);
		
	}


}
