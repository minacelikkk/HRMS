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
@Table(name="candidate_images")
public class CandidateImage {
	
    @Id
   
    @Column(name = "id")
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

  
    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


    
}