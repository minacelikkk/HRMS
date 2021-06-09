
package kodlamaio.hrms.entities.concretes;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="programming_skills")

public class ProgrammingSkill {
	
	@Id
   
    @Column(name = "id")
    private int id;

    @Column(name = "name")
 
    private String name;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}