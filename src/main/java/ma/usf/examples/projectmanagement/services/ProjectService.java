package ma.usf.examples.projectmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.usf.examples.projectmanagement.dao.ProjectRepository;
import ma.usf.examples.projectmanagement.dto.ChartData;
import ma.usf.examples.projectmanagement.dto.TimeChartData;
import ma.usf.examples.projectmanagement.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository proRepo;

	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public Project getById(long id) {
		return proRepo.findById(id).orElseThrow(NullPointerException::new);
	}

	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}
	
	public void delete(long id) {
		proRepo.deleteById(id);
	}

	public List<TimeChartData> getTimeChartData() {
		return proRepo.getTimeData();
	}
}
