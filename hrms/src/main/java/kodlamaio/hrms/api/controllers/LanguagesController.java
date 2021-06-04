package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Language;
@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@PostMapping("/add")
	public Result add(@Valid @RequestBody Language language) {
		return this.languageService.add(language);
		
	}
	@GetMapping("/getByCandidateId")
	public DataResult<List<Language>> getByCandidateId(int candidateId) {
		return this.languageService.getByCandidateId(candidateId);
	}
	@GetMapping("/getAll")
	public DataResult<List<Language>> getAll(){
		return this.languageService.getAll();	
		}
	
}
