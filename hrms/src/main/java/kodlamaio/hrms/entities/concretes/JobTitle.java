package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="job_titles")
@Entity

public class JobTitle {
	@Id
	
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String jobTitle;
	
	@OneToMany(mappedBy="jobTitle")
	private List<JobAdvertisement> jobAdvertisement;

}
