package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/add")
	public Result add(@RequestBody Prewriting prewriting) {
		return this.prewritingService.add(prewriting);
		
	}

}
