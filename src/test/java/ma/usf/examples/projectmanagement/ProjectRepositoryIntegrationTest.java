//package ma.usf.examples.dao;
package ma.usf.examples.projectmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ma.usf.examples.projectmanagement.dao.ProjectRepository;
import ma.usf.examples.projectmanagement.entities.Project;

//@ContextConfiguration(classes = ProjectManagementApplication.class)
//@DataJpaTest
@SpringBootTest
@ExtendWith(SpringExtension.class)
//@SqlGroup({
//		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:schema.sql",
//				"classpath:data.sql" }),
//		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:schema.sql") })
public class ProjectRepositoryIntegrationTest {

	@Autowired
	ProjectRepository proRepo;

	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
		proRepo.save(newProject);

		assertEquals(1, proRepo.findAll().size());
	}
}
