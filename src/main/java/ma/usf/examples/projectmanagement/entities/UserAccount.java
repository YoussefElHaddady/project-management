package ma.usf.examples.projectmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_accounts")
@Data
@NoArgsConstructor
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_accounts_generator")
	@SequenceGenerator(name = "user_accounts_generator", sequenceName = "user_accounts_seq", allocationSize = 1)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "username")
	private String userName;

	private String email;

	private String password;

	private String role;

	private boolean enabled = true;

}
