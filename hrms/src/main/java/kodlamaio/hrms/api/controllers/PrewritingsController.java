package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PrewritingService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Prewriting;


@RestController
@RequestMapping("/api/prewritings")

public class PrewritingsController {
	private PrewritingService prewritingService;
	@Autowired
	public PrewritingsController(PrewritingService prewritingService) {
		super();
		this.prewritingService = prewritingService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody Prewriting prewriting) {
		return this.prewritingService.add(prewriting);
		
	}

}
