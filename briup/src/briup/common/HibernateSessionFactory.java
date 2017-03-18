package briup.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	static{
		Configuration config=new Configuration();
		config.configure();
		factory =config.buildSessionFactory();
		}
	public static Session getSession(){
		Session session=threadLocal .get();
		if(session==null){
			session=factory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
}
