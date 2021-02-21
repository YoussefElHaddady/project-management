package ma.usf.examples.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.usf.examples.projectmanagement.dao.EmployeeRepository;
import ma.usf.examples.projectmanagement.dao.ProjectRepository;
import ma.usf.examples.projectmanagement.dto.ChartData;
import ma.usf.examples.projectmanagement.dto.EmployeeProject;
import ma.usf.examples.projectmanagement.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

		List<Project> projects = proRepo.findAll();
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		List<ChartData> projectStatus = proRepo.getProjectStatus();

		// Convert projectStatus object into a JSON structure for use in JavaScript
		ObjectMapper objMapper = new ObjectMapper();
		String jsonStr = objMapper.writeValueAsString(projectStatus);

		model.addAttribute("projects", projects);
		model.addAttribute("employees", employeesProjectCount);
		model.addAttribute("projectStatusCount", jsonStr);
		return "main/home";
	}
}
