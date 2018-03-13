package SpringMy.Maven.db.enities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "useraccess", catalog = "salontest", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class Useraccess implements java.io.Serializable{
	
	
	private String user_role_id;
	private String user_id;
	private String role;

	public Useraccess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Useraccess(String user_role_id, String user_id, String role) {
		super();
		this.user_role_id = user_role_id;
		this.user_id = user_id;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public String getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(String user_role_id) {
		this.user_role_id = user_role_id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
