package com.mycompany.librarymanagementsystem.dao.author;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

public class AuthorDao {
    
    public void add(AuthorDetails ad) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ad);
            transaction.commit();
        } catch (Exception e) {
            
            if (transaction != null) {
                
                transaction.rollback();
            }
            e.printStackTrace();
            
        }
        
    }
    
    public List<AuthorDetails> getAuthorList() {
        
        List<AuthorDetails> ls = new ArrayList<AuthorDetails>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(AuthorDetails.class);
            t.commit();
            ls = c.list();
        } catch (Exception e) {
            
            if (t != null) {
                t.rollback();
            }
        }
        return ls;
    }
    
    public List getNames() {
        
        List<String> l = new ArrayList<String>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(AuthorDetails.class);
            l = (List<String>) c.setProjection(Projections.property("name"));
            t.commit();
            
        } catch (Exception e) {
            
            if (t != null) {
                t.rollback();
            }
        }
        return l;
    }
    
}

