package ma.usf.examples.projectmanagement.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS
	
	private String description;
	
	@OneToMany(mappedBy = "project")
	private List<Employee> employees;
}
