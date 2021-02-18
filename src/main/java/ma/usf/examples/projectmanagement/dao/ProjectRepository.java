package ma.usf.examples.projectmanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ma.usf.examples.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	List<Project> findAll();

}
