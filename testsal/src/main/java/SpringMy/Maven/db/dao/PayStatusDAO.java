package SpringMy.Maven.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import SpringMy.Maven.db.enities.PayStatus;
import SpringMy.Maven.model.UserStatusDisplayDTO;

public class PayStatusDAO {
	
 private static final Log log = LogFactory.getLog(PayStatusDAO.class);
	 
	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 
	 public void persist(PayStatus transientInstance){
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
	 
	
	 public void attachDirty(PayStatus instance) {
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
	 
	public List<PayStatus> findByExample(PayStatus instance) {
		 log.debug("finding User instance by example");
			try {
				session = sessionFactory.openSession();
				   Criteria criteria = session.createCriteria(PayStatus.class);
				                     criteria.add(Restrictions.eq("users",instance.getUsers()));
				                     
			   List<PayStatus> result = criteria.list(); 
			   return result;
				
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		 
	 }
	
	
	public void delete(PayStatus persistentInstance) {
		log.debug("deleting Domain instance");
		try {			
			 session = sessionFactory.openSession();
			 transaction = session.beginTransaction();
			 session.delete(persistentInstance);
			 log.debug("delete successful");
			 transaction.commit();
			 session.close();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	
	public List<UserStatusDisplayDTO> fetchSql(String sql){
		log.debug("PayStatus instance : " + sql);
		try {
			 Session session = sessionFactory.openSession();
			 Transaction transaction = session.beginTransaction();
			 @SuppressWarnings("unchecked")
			 List<UserStatusDisplayDTO> results = session.createSQLQuery(sql)
							  .addScalar("user_id", StandardBasicTypes.INTEGER)
							  .addScalar("first_name", StandardBasicTypes.STRING)
							  .addScalar("last_name", StandardBasicTypes.STRING)
							  .addScalar("club", StandardBasicTypes.STRING)
							  .addScalar("country", StandardBasicTypes.STRING)
							  .addScalar("attempt_section", StandardBasicTypes.INTEGER)
							  .addScalar("total_entry", StandardBasicTypes.INTEGER)
							  .addScalar("paying_status", StandardBasicTypes.STRING)
							  .setResultTransformer( Transformers.aliasToBean(UserStatusDisplayDTO.class))
							  .list();
			
			 transaction.commit();
			 session.close(); 
			 if(results.size()>0)
				return results; 				 			
		    }catch (RuntimeException re) {
				log.error("fatch UserGroupRole failed", re);
				throw re;
			}
		return new ArrayList();
	}

}
