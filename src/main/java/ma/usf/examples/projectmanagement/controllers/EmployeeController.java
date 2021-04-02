package ma.usf.examples.projectmanagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.usf.examples.projectmanagement.entities.Employee;
import ma.usf.examples.projectmanagement.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeService.getAll();

		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}

	@PostMapping("/save")
	public String createEmployee(Model model, @Valid Employee employee, Errors errors) {

		if(errors.hasErrors())
			return "employees/new-employee"; 

		employeeService.save(employee);

		return "redirect:/employees/new";
	}

	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") Long id, Model model) {

		Employee emp = employeeService.getById(id);
		model.addAttribute("employee", emp);
		return "employees/new-employee";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Long id, Model model) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
}
