package ma.usf.examples.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.usf.examples.projectmanagement.entities.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
