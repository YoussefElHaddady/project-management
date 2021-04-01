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

import ma.usf.examples.projectmanagement.entities.Project;
import ma.usf.examples.projectmanagement.services.ProjectService;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectApiController {

	@Autowired
	private ProjectService projectService;

	@GetMapping
	public List<Project> getProjects() {
		return projectService.getAll();
	}

	@GetMapping("/{id}")
	public Project getProject(@PathVariable("id") Long id) {
		return projectService.getById(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project create(@RequestBody @Valid Project project) {
		return projectService.save(project);
	}

	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project update(@RequestBody @Valid Project project) {
		return projectService.save(project);
	}

	@PatchMapping(value = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project partialUpdate(@RequestBody @Valid Project patchProject, @PathVariable("id") Long id) {
		Project prj = projectService.getById(id);

		if (patchProject.getName() != null) {
			prj.setName(patchProject.getName());
		}
		if (patchProject.getDescription() != null) {
			prj.setDescription(patchProject.getDescription());
		}
		if (patchProject.getStage() != null) {
			prj.setStage(patchProject.getStage());
		}

		return projectService.save(prj);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			projectService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

}
