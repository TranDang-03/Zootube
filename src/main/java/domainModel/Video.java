package domainModel;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="video")
public class Video {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="href")
	private String href;
	
	@Column(name="poster")
	private String poster;
	
	@Column(name="viewss")
	private int viewss;
	
	@Column(name="shares")
	private int shares;
	
	@Column(name="description")
	private String description;
	
	@Column(name="isActive")
	private boolean isactive;

	public Video(String title, String href, String poster, int viewss, int shares, String description,
			boolean isactive) {
		super();
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.viewss = viewss;
		this.shares = shares;
		this.description = description;
		this.isactive = isactive;
	}

	public Video() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getViewss() {
		return viewss;
	}

	public void setViewss(int viewss) {
		this.viewss = viewss;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description; 
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, href, id, isactive, poster, shares, title, viewss);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		return Objects.equals(description, other.description) && Objects.equals(href, other.href) && id == other.id
				&& isactive == other.isactive && Objects.equals(poster, other.poster) && shares == other.shares
				&& Objects.equals(title, other.title) && viewss == other.viewss;
	}
		
	
}
