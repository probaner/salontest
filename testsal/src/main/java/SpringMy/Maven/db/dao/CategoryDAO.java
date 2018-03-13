package SpringMy.Maven.db.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import SpringMy.Maven.db.enities.Category;

public class CategoryDAO {
	
	
	private static final Log log = LogFactory.getLog(UsersDAO.class);

	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	
	 
	 public Integer getCategoryID(String categoryName){
	 log.debug("categoryName instance");
	  try {	 
		   session = sessionFactory.openSession();
		   Criteria criteria = session.createCriteria(Category.class);
		                     criteria.add(Restrictions.eq("categoryName", categoryName));
		                     criteria.setProjection(Property.forName("categoryId")).uniqueResult();
		                     
		   Integer id = (Integer) criteria.list().get(0);            
		   		   
		   System.out.println("value="+id); 
		   
		   session.close();                 
		   return id;
	      } catch (RuntimeException re) {
	         log.error("categoryName failed", re);
	         throw re;
          }
		 
	 }

}
