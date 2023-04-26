package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import domainModel.History;
import domainModel.User;
import domainModel.Video;
import repository.UserRepo;
import repository.VideoRepo;



public class HibernateUtil {

	private static final SessionFactory FACTORY;

	static {
		Configuration conf = new Configuration();

		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
		properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=ASSIGNMENT4");
		properties.put(Environment.USER, "sa");
		properties.put(Environment.PASS, "dangdzai");
		properties.put(Environment.SHOW_SQL, "true");
		conf.setProperties(properties);
		conf.addAnnotatedClass(History.class);
		conf.addAnnotatedClass(User.class);
		conf.addAnnotatedClass(Video.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);
	}

	public static SessionFactory getFACTORY() {
		return FACTORY;
	}

	public static void main(String[] args) {
		
//		VideoRepo vd =  new VideoRepo();
		UserRepo us = new UserRepo();
//		System.out.println(us.checkTrungEmail("huynh@gmail.com"));
//		System.out.println(us.findUserByName("john"));
//		System.out.println(us.checkLogin("huynh@gmail.com", "D74FF0EE8DA3B9806B18C877DBF29BBDE50B5BD8E4DAD7A3A725000FEB82E8F1"));
	}
}
