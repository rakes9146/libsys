
package com.mycompany.librarymanagementsystem.dao.publisher;

import com.mycompany.librarymanagementsystem.beans.publisher.Publisher;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class PublisherDao {
    
    public void save(Publisher publisher){
    
        
         Session  session= HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
         try{
                 transaction = session.beginTransaction();
                 session.save(publisher);
                 transaction.commit();
                 
         }catch(Exception e){
          
               if(transaction != null){
               
                    transaction.rollback();
               }
         }
          
    }
   
     
}
