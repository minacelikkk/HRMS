package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

@RestController
@RequestMapping("/api/programmingSkills")

public class ProgrammingSkillsController {
	private ProgrammingSkillService programmingSkillService;
	@Autowired
	public ProgrammingSkillsController(ProgrammingSkillService programmingSkillService) {
		super();
		this.programmingSkillService = programmingSkillService;
	}
	
	@GetMapping("/add")
	public Result add(ProgrammingSkill programmingSkill) {
		return this.programmingSkillService.add(programmingSkill);
	}
	
}
