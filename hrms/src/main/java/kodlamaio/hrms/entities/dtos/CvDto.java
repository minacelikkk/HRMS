package kodlamaio.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.Prewriting;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;
import kodlamaio.hrms.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CvDto {
	@JsonIgnore()
	private Candidate candidate;
	private List<School> schools;
	private List<JobExperience> experiences;
	private List<Language> languages;
	private List<Prewriting> prewritings;
	private List<ProgrammingSkill> programmingSkills;
	private CandidateImage candidateImages;
	private List<Link> links;
}


