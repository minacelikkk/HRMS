package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name="candidates")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)

@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")

public class Candidate extends User {

	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="identity_number")
	private String identityNumber;
	@Column(name="birth_year")
	private String birthYear;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<School> schoolInfos;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<Language> languages;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<Link> links;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<ProgrammingSkill> skills;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore()
	private List<Prewriting> prewritings;
	
	@OneToOne(mappedBy = "candidate")
	@JsonIgnore()
	private CandidateImage candidateImage;
	


	

	

}
