package domainModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="nguoi_dung")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="isAdmin")
	private boolean isadmin;
	
	@Column(name="isActive")
	private boolean isactive;

	public User(String username, String password, String email, boolean isadmin, boolean isactive) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.isadmin = isadmin;
		this.isactive = isactive;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
		
}
