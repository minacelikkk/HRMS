package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name="employers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)

@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Employer extends User {
	
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	

}
