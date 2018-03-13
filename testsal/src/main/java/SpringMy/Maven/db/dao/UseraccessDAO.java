package SpringMy.Maven.db.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import SpringMy.Maven.db.enities.Useraccess;

public class UseraccessDAO {
	
	 private static final Log log = LogFactory.getLog(UseraccessDAO.class);

	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
		
	 public void persist(Useraccess transientInstance) {
		log.debug("persisting Domain instance");
		try {			
			 session = sessionFactory.openSession();
			 transaction = session.beginTransaction();
			 session.save(transientInstance);
			 log.debug("persist successful");
			 transaction.commit();
			 session.close();
		    } catch (RuntimeException re) {
			         log.error("persist failed", re);
			         throw re;
		             }
	}

}
