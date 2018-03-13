package SpringMy.Maven.db.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringMy.Maven.db.enities.Users;


@Repository
public class UsersDAO {
	
	 private static final Log log = LogFactory.getLog(UsersDAO.class);

	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 @Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
		
	 public void persist(Users transientInstance) {
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
	 
	 public void attachDirty(Users instance) {
			log.debug("attaching dirty User instance");
			try {				 
				 session = sessionFactory.openSession();
				 transaction = session.beginTransaction();
				 session.saveOrUpdate(instance);
				 log.debug("attach successful");
				 transaction.commit();
				 session.close();
			} catch (RuntimeException re) {
				log.error("attach failed", re);
				throw re;
			}
		}
	 
	 
	public Users findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Users instance = (Users) session.get("SpringMy.Maven.db.enities.Users", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			    }
			
		   } catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		   }
		return null;
		
	}
	
	public List<Users> findAColumn(String nameOfColumn){
		try{
			session = sessionFactory.openSession();
			Criteria cr =session.createCriteria(Users.class)
		    .setProjection(Projections.projectionList()		      
		    .add(Projections.property(nameOfColumn), nameOfColumn))
		    .setResultTransformer(Transformers.aliasToBean(Users.class));
			
			 List<Users> list = cr.list();
			 
			 return list;
		   } catch (RuntimeException re) {
			                               log.error("get failed", re);
			                               throw re;
		                                  }		
	 }
	
	
	public String findPassword(String email){
		String password =null;
		try{
			session = sessionFactory.openSession();
			Criteria cr =session.createCriteria(Users.class);
					     cr.add(Restrictions.eq("email", email));
			             cr.setProjection(Property.forName("password")).uniqueResult();
			             password = (String) cr.list().get(0);		             			            
		}catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
           }
		return password;
	}
	
	
	public List findByExample(Users instance) {
		log.debug("finding User instance by example");
		try {
			//List results = sessionFactory.getCurrentSession().createCriteria("com.ericsson.ucefdatabinding.User").add(Example.create(instance)).list();
			 session = sessionFactory.openSession();
			 transaction = session.beginTransaction();
			 List results = session.createCriteria("SpringMy.Maven.db.enities.Users").add(Example.create(instance)).list();
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
