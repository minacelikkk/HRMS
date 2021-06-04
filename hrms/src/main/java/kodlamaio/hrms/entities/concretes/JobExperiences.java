package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="job_experiences")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidates"})
public class JobExperiences {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@JoinColumn(name="candidates_id")
	private Candidate candidate;

}
