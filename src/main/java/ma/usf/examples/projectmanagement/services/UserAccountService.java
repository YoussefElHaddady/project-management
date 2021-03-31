package ma.usf.examples.projectmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.usf.examples.projectmanagement.dao.UserAccountRepository;
import ma.usf.examples.projectmanagement.entities.UserAccount;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userRepo;
	
	public UserAccount save(UserAccount user) {
		return userRepo.save(user);
	}
}
