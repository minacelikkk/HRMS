package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name="employees")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")

public class Employee extends User{
	
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	
	public Employee(int id, String email, String password, String first_name, String last_name) {
		super(id, email, password);
		this.first_name = first_name;
		this.last_name = last_name;
	}

}
