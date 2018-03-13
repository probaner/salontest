package SpringMy.Maven.db.enities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;



@SuppressWarnings("serial")
@Entity
@Table(name = "users", catalog = "salontest", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class Users implements java.io.Serializable{
	
	private Integer user_id;
	private String first_name;
	private String last_name;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String country;
	private String club;
	private String honer;
	private String email;
	private String password;
	private Date created_on; 
	private Date last_loggin;
	private String role;
	
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	 }

	public Users(Integer user_id, String first_name, String last_name, String gender, String address, String city,
			String stste, String country, String club, String honer, String email, String password,
			String final_password, Date created_on, Date last_loggin, String state, String role) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.club = club;
		this.honer = honer;
		this.email = email;
		this.password = password;
		this.created_on = created_on;
		this.last_loggin = last_loggin;
		this.role=role;
	}
	
	
	
	

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	
	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Column(name = "last_name", nullable = false, length = 45)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column(name = "gender", nullable = false, length = 45)	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "address", nullable = false, length = 45)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false, length = 45)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false, length = 45)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", nullable = false, length = 45)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "club", nullable = true, length = 45)
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}

	@Column(name = "honer", nullable = true, length = 45)
	public String getHoner() {
		return honer;
	}
	public void setHoner(String honer) {
		this.honer = honer;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", unique = true, nullable = false, length = 45)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_loggin", nullable = false, length = 19)
	public Date getLast_loggin() {
		return last_loggin;
	}
	public void setLast_loggin(Date last_loggin) {
		this.last_loggin = last_loggin;
	}
	
	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", club=" + club + ", honer=" + honer + ", email=" + email + ", password=" + password
				+ ", created_on=" + created_on + ", last_loggin=" + last_loggin + ", role=" + role + "]";
	}

}
