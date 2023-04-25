package domainModel;

import java.sql.Timestamp;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="history")
public class History {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userId", referencedColumnName = "id")
	@JsonIgnoreProperties(value= {"applications","hibernateLazyInitializer"})
	private User user;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="videoId", referencedColumnName = "id")
	@JsonIgnoreProperties(value= {"applications","hibernateLazyInitializer"})
	private Video video;
	
	@Column(name="viewedDate")
	@CreationTimestamp
	private Timestamp vieweddate;
	
	@Column(name="isLiked")
	private boolean isliked;
	
	@Column(name="isLikedDate")
	@CreationTimestamp
	private Timestamp isLikeddate;

	public History(User user, Video video, Timestamp vieweddate, boolean isliked, Timestamp isLikeddate) {
		super();
		this.user = user;
		this.video = video;
		this.vieweddate = vieweddate;
		this.isliked = isliked;
		this.isLikeddate = isLikeddate;
	}

	public History() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Timestamp getVieweddate() {
		return vieweddate;
	}

	public void setVieweddate(Timestamp vieweddate) {
		this.vieweddate = vieweddate;
	}

	public boolean isIsliked() {
		return isliked;
	}

	public void setIsliked(boolean isliked) {
		this.isliked = isliked;
	}

	public Timestamp getIsLikeddate() {
		return isLikeddate;
	}

	public void setIsLikeddate(Timestamp isLikeddate) {
		this.isLikeddate = isLikeddate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isLikeddate, isliked, user, video, vieweddate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		return id == other.id && Objects.equals(isLikeddate, other.isLikeddate) && isliked == other.isliked
				&& Objects.equals(user, other.user) && Objects.equals(video, other.video)
				&& Objects.equals(vieweddate, other.vieweddate);
	}	
		
}
