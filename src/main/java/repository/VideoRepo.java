package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import domainModel.Video;
import domainModel.VideoLikedInfo;
import jakarta.persistence.TypedQuery;
import util.HibernateUtil;

public class VideoRepo {

	private Session session;

	public VideoRepo() {
		this.session = HibernateUtil.getFACTORY().openSession();
	}
	
	public void inertVideo(Video video) {
		try {
			this.session.getTransaction().begin();
			this.session.persist(video);
			this.session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}
	
	public void updateVideo(Video video) {
		try {
			this.session.getTransaction().begin();
			this.session.merge(video);
			this.session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}
	
	public void deleteVideo(Video video) {
		try {
			this.session.getTransaction().begin();
			this.session.remove(video);
			this.session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}
	
	public List<Video> findAll(){
		String hql = "SELECT vd FROM Video vd WHERE vd.isactive = 1";
		TypedQuery<Video> query = this.session.createQuery(hql,Video.class);
		return query.getResultList();
	}
	
	public Video FindById(int id) {
		String hql = "SELECT vd FROM Video vd WHERE vd.id = ?1";
		TypedQuery<Video> query = this.session.createQuery(hql,Video.class);
		query.setParameter(1,id);
		return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<VideoLikedInfo> findUserByHref(String href){
		NativeQuery<VideoLikedInfo> query = this.session.createNativeQuery(
				"SELECT u.username, u.email FROM nguoi_dung u INNER JOIN history h"
				+ " ON u.id = h.userId INNER JOIN video v on v.id = h.videoId"
				+ " WHERE v.href = ?1 AND u.isActive = 1 AND v.isActive = 1 AND h.isLiked = 1");
		query.setParameter(1, href);
		return query.getResultList();
	}
	
	
	
}
