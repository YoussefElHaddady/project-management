package ma.usf.examples.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ma.usf.examples.projectmanagement.dao.EmployeeRepository;
import ma.usf.examples.projectmanagement.dao.ProjectRepository;
import ma.usf.examples.projectmanagement.entities.Employee;
import ma.usf.examples.projectmanagement.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = proRepo.findAll();
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("projects", projects);
		model.addAttribute("employees", employees);
		return "main/home";
	}
}
