package ma.usf.examples.projectmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ma.usf.examples.projectmanagement.dto.EmployeeProject;
import ma.usf.examples.projectmanagement.entities.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();

	@Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount "
			+ "FROM employee e left join project_employee pe ON pe.employee_id = e.id "
			+ "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();

	public Optional<Employee> findByEmail(String email);
}
