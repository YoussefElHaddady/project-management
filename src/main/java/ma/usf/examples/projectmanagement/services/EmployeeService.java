package ma.usf.examples.projectmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ma.usf.examples.projectmanagement.dao.EmployeeRepository;
import ma.usf.examples.projectmanagement.dto.EmployeeProject;
import ma.usf.examples.projectmanagement.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public Employee getById(long id) {
		return empRepo.findById(id).orElseThrow(NullPointerException::new);
	}

	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}

	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}

	public void delete(Long id) {
		empRepo.deleteById(id);
	}

	public Employee getByEmail(String value) {
		return empRepo.findByEmail(value).orElseThrow(NullPointerException::new);
	}

	public Iterable<Employee> getAll(Pageable pageable) {
		return empRepo.findAll(pageable);
	}

}
