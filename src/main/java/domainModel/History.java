package domainModel;

import java.sql.Timestamp;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="history")
public class History {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userId")
	private int userid;
	
	@Column(name="videoId")
	private int videoid;
	
	@Column(name="viewedDate")
	@CreationTimestamp
	private Timestamp vieweddate;
	
	@Column(name="isLiked")
	private boolean isliked;
	
	@Column(name="isLikedDate")
	@CreationTimestamp
	private Timestamp isLikeddate;

	public History(int userid, int videoid, Timestamp vieweddate, boolean isliked, Timestamp isLikeddate) {
		super();
		this.userid = userid;
		this.videoid = videoid;
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
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
		
}
