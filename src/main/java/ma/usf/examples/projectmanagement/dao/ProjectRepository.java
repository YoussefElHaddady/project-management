package ma.usf.examples.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import ma.usf.examples.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
