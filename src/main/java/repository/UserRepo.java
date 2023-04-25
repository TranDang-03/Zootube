package repository;

import java.util.List;

import org.hibernate.Session;

import domainModel.User;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import util.HibernateUtil;

public class UserRepo {

	private Session session;

	public UserRepo() {
		this.session = HibernateUtil.getFACTORY().openSession();
	}

	public void insertUser(User user) {
		try {
			this.session.getTransaction().begin();
			this.session.persist(user);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}

	public void updateUser(User user) {
		try {
			this.session.getTransaction().begin();
			this.session.merge(user);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}

	public void deleteUser(User user) {
		try {
			this.session.getTransaction().begin();
			this.session.remove(user);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.session.getTransaction().rollback();
		}
	}

	public List<User> findAll() {
		String hql = "SELECT u FROM User u WHERE u.isactive = 1";
		TypedQuery<User> query = this.session.createQuery(hql, User.class);
		return query.getResultList();
	}

	public User findUserById(int id) {
		String hql = "SELECT u FROM User u WHERE u.id = ?1";
		TypedQuery<User> query = this.session.createQuery(hql, User.class);
		query.setParameter(1, id);
		return query.getSingleResult();
	}

	public List<User> findUserByName(String name) {
		String hql = "SELECT u FROM User u WHERE u.username LIKE ?1";
		TypedQuery<User> query = this.session.createQuery(hql, User.class);
		query.setParameter(1, "%" + name + "%");
		return query.getResultList();
	}

	public User checkTrungEmail(String email) {
		User user = null;
		try {
			String hql = "SELECT u FROM User u WHERE u.email = :email";
			Query query = this.session.createQuery(hql);
			query.setParameter("email", email);
			user = query.getSingleResult() == null ? null : (User) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
