package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_advertisements")

public class JobAdvertisement {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_positions")
	private String openPositions;
	
	@Column(name="min_salary")
	private String minSalary;
	
	@Column(name="max_salary")
	private String maxSalary;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
		
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	
	
	@ManyToOne
	@JoinColumn(name="jobTitle_id")
	private JobTitle jobTitle;

	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()	
	@JoinColumn(name = "city_id")
	private City city;
	
	

	
}
