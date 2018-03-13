package SpringMy.Maven.db.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import SpringMy.Maven.db.enities.FileDetail;
import SpringMy.Maven.db.enities.Users;

public class FileDetailDAO {
	
	 private static final Log log = LogFactory.getLog(FileDetailDAO.class);
	 
	 private SessionFactory sessionFactory;
	 private Transaction transaction;
	 private Session session;
	 
	 public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	       }
	 
	 public void persist(FileDetail transientInstance){
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
	 
	 
	 public void delete(FileDetail persistentInstance) {
		      // System.out.println("check data====="+persistentInstance.getUsers().getUser_id()+"    " +persistentInstance.getCategory().getCategoryId()+"  "+persistentInstance.getTitel() );
			log.debug("deleting File instance");
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
	 
	 
	 public FileDetail findFile(FileDetail fileDetail){
		 log.debug("File instance"); 
		 try {	 
			   session = sessionFactory.openSession();
			   Criteria criteria = session.createCriteria(FileDetail.class);
			                     criteria.add(Restrictions.eq("users",fileDetail.getUsers()));
			                     criteria.add(Restrictions.eq("category", fileDetail.getCategory()));
			                     criteria.add(Restrictions.like("originalFileName", fileDetail.getOriginalFileName()));
			                     //criteria.setProjection(Property.forName("fileId"));
			                     
			                     FileDetail result = (FileDetail) criteria.uniqueResult();  
			                     session.close();
			                     return result;
		 } catch (RuntimeException re) {
	         log.error("get file_id failed", re);
	         throw re;
          }		 
	 }
	 
	 public List<String> findTitelListOfaCatagory(FileDetail fileDetail){
		 
		 log.debug("File instance");		 
		  try {	 
			   session = sessionFactory.openSession();
			   Criteria criteria = session.createCriteria(FileDetail.class);
			                     criteria.add(Restrictions.eq("users",fileDetail.getUsers()));
			                     criteria.add(Restrictions.eq("category", fileDetail.getCategory()));
			                     criteria.setProjection(Property.forName("titel"));
			                     
			   List<String> listOfTitel =  criteria.list();            
			   		   
			   System.out.println("value="+listOfTitel); 
			   
			   session.close();                 
			   return listOfTitel;
		      } catch (RuntimeException re) {
		         log.error("File_Name failed", re);
		         throw re;
	          }
			 
		 }
	 
	 public List<FileDetail> findByExample(FileDetail instance) {
		 log.debug("finding User instance by example");
			try {
				session = sessionFactory.openSession();
				   Criteria criteria = session.createCriteria(FileDetail.class);
				                     criteria.add(Restrictions.eq("users",instance.getUsers()));
				                     criteria.addOrder(Order.asc("upload_time"));
				                     
			   List<FileDetail> result = criteria.list(); 
			   return result;
				
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		 
	 }
	 
	
	 /*public List findByExample(FileDetail instance) {
			log.debug("finding User instance by example");
			try {				
				 session = sessionFactory.openSession();
				 transaction = session.beginTransaction();
				 List results = session.createCriteria("SpringMy.Maven.db.enities.FileDetail").add(Example.create(instance)).list();
				 log.debug("find by example successful, result size: " + results.size());
				 transaction.commit();
				 session.close();
				return results;
			} catch (RuntimeException re) {
				log.error("find by example failed", re);
				throw re;
			}
		}*/
	 
	 
	 /*public String getoriginalFileName(File file){
		 log.debug("File instance"); 
		 try {	 
			   session = sessionFactory.openSession();
			   Criteria criteria = session.createCriteria(File.class);
			                     criteria.add(Restrictions.eq("users",file.getUsers()));
			                     criteria.add(Restrictions.eq("category", file.getCategory()));
			                     criteria.add(Restrictions.eq("titel", file.getTitel()));
			                     criteria.setProjection(Property.forName("originalFileName"));
			                     
			                     String result = (String) criteria.uniqueResult();  
			                     session.close();
			                     return result;
		 } catch (RuntimeException re) {
	         log.error("get file_id failed", re);
	         throw re;
          }		 
	 }*/

}
