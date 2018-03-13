package SpringMy.Maven.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UserDTO {	
    private Integer userid;
	private String firstname;
	private String lastname;
    private String gender;
    private String address;
    private String pin;
    private String country;
    private String city;
    private String club;
    private String honer;
    private String email;
    private String password;
    
    
    
    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public UserDTO(Integer userid, String firstname, String lastname, String gender, String address, String pin,
			String country, String city, String club, String honer, String email, String password) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
		this.pin = pin;
		this.country = country;
		this.city = city;
		this.club = club;
		this.honer = honer;
		this.email = email;
		this.password = password;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getHoner() {
		return honer;
	}

	public void setHoner(String honer) {
		this.honer = honer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", gender="
				+ gender + ", address=" + address + ", pin=" + pin + ", country=" + country + ", city=" + city
				+ ", club=" + club + ", honer=" + honer + ", email=" + email + ", password=" + password + "]";
	}
	
   
}
