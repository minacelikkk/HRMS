package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ProgrammingSkill programmingSkill) {
		return this.programmingSkillService.add(programmingSkill);
	}
	
}
