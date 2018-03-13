package SpringMy.Maven.model;

public class UserStatusDisplayDTO {
	
	private int user_id;
	private String first_name;
	private String last_name;
	private String club;
	private String country;
	private int attempt_section;
	private int total_entry;
	private String paying_status;
	public UserStatusDisplayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserStatusDisplayDTO(int user_id, String first_name, String last_name, String club, String country,
			int attempt_section, int total_entry, String paying_status) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.club = club;
		this.country = country;
		this.attempt_section = attempt_section;
		this.total_entry = total_entry;
		this.paying_status = paying_status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAttempt_section() {
		return attempt_section;
	}
	public void setAttempt_section(int attempt_section) {
		this.attempt_section = attempt_section;
	}
	public int getTotal_entry() {
		return total_entry;
	}
	public void setTotal_entry(int total_entry) {
		this.total_entry = total_entry;
	}
	public String getPaying_status() {
		return paying_status;
	}
	public void setPaying_status(String paying_status) {
		this.paying_status = paying_status;
	}
	@Override
	public String toString() {
		return "UserStatusDisplayDTO [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", club=" + club + ", country=" + country + ", attempt_section=" + attempt_section + ", total_entry="
				+ total_entry + ", paying_status=" + paying_status + "]";
	}
	
	
	
	
	
	
	
	
	

}
