package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")

	private List<School> schools;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")
	
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")
	
	private List<Language> languages;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")
	
	private List<Link> links;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")
	
	private List<ProgrammingSkill> programmingSkills;

	@JsonIgnore()
	@OneToMany(mappedBy = "candidate")
	
	private List<Prewriting> prewritings;

	public Candidate(int id, String email, String password, String firstName, String lastName, String identityNumber,
			String birthYear) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthYear = birthYear;
	}


	

	

}
