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
@Table(name = "links")
@AllArgsConstructor
@NoArgsConstructor
public class Link {
	
	@Id
	@Column(name = "id")
	private int id;
	
    @Column(name = "title")
 
    private String title;
    
    @Column(name = "url")
    private String url;
    
    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}