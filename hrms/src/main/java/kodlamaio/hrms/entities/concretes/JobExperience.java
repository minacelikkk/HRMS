package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="job_experiences")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class JobExperience {
	@Id
	
	@Column(name="id")
	private int id;
	@Column(name="workplace_name")
	private String workplaceName;
	@Column(name="position")
	private String position;
	@Column(name="date_of_start")
	private LocalDate dateOfStart;
	@Column(name="date_of_end")
	private LocalDate dateOfEnd;
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

}
