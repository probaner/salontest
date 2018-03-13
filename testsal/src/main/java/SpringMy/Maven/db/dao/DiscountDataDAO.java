package SpringMy.Maven.db.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import SpringMy.Maven.db.enities.DiscountData;
import SpringMy.Maven.db.enities.Users;

public class DiscountDataDAO {
	
 private static final Log log = LogFactory.getLog(PayStatusDAO.class);
	 
	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 
	 
	 public List findByExample(DiscountData instance) {
			log.debug("finding User instance by example");
			try {				
				 session = sessionFactory.openSession();
				 transaction = session.beginTransaction();
				 List results = session.createCriteria("SpringMy.Maven.db.enities.DiscountData").add(Example.create(instance)).list();
				 log.debug("find by example successful, result size: " + results.size());
				 transaction.commit();
				 session.close();
				return results;
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		}
	 

}
