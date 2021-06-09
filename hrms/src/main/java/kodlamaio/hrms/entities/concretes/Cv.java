package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cv")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)



public class Cv {
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "cv")
	
	private List<Candidate> candidates;

}
