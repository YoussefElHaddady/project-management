package ma.usf.examples.projectmanagement.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;

	private String lastName;

	private String email;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST },
			fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;
}
