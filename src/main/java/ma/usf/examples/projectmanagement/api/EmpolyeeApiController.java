package ma.usf.examples.projectmanagement.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.usf.examples.projectmanagement.entities.Employee;
import ma.usf.examples.projectmanagement.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmpolyeeApiController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeService.getById(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody @Valid Employee employee) {
		return employeeService.save(employee);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody @Valid Employee employee) {
		return employeeService.save(employee);
	}
	
	@PatchMapping(path="/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Employee patchEmployee) {
		Employee emp = employeeService.getById(id);
		
		if(patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		if(patchEmployee.getFirstName() != null) {
			emp.setFirstName(patchEmployee.getFirstName());
		}
		if(patchEmployee.getLastName() != null) {
			emp.setLastName(patchEmployee.getLastName());
		}
		
		return employeeService.save(emp);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			employeeService.delete(id);			
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
}
