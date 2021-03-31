package ma.usf.examples.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.usf.examples.projectmanagement.entities.Project;
import ma.usf.examples.projectmanagement.services.EmployeeService;
import ma.usf.examples.projectmanagement.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = projectService.getAll();

		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", employeeService.getAll());

		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		// handle saving to the database ...
		projectService.save(project);

		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
}
