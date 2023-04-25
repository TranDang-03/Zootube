package domainModel;

import java.util.Objects;

public class VideoLikedInfo {

	String username;
	String email;
	
	public VideoLikedInfo(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public VideoLikedInfo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoLikedInfo other = (VideoLikedInfo) obj;
		return Objects.equals(email, other.email) && Objects.equals(username, other.username);
	}
	
	
}
