package ma.usf.examples.projectmanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
	@SequenceGenerator(name = "project_generator", sequenceName = "project_seq", allocationSize = 1)
	private long id;

	@NonNull
	private String name;

	@NonNull
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS

	@NonNull
	private String description;

//	@OneToMany(mappedBy = "project")
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
	@JsonIgnore
	private List<Employee> employees;

	public Project(@NonNull String name, @NonNull String stage, @NonNull String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public void addEmployee(Employee emp) {
		if (employees == null) {
			employees = new ArrayList<>();
		}

		employees.add(emp);
	}

}
