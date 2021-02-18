package ma.usf.examples.projectmanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ma.usf.examples.projectmanagement.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	List<Employee> findAll();

}
