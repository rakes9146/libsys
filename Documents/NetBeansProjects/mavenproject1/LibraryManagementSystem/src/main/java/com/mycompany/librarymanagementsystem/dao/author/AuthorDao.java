package com.mycompany.librarymanagementsystem.dao.author;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

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
        ArrayList<String> result = new ArrayList<String>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            result = (ArrayList<String>) session.createSQLQuery("SELECT name FROM author").list();

            t.commit();

        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public void update(String updated_value, int id, String option) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();

            if ("address".equals(option)) {

                Query q = session.createQuery("UPDATE author SET adddress = :adddress WHERE id = :id");
                q.setParameter("adddress", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("mobno".equals(option)) {

                Query q = session.createQuery("UPDATE author SET phone = :phone WHERE id = :id");
                q.setParameter("phone", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("email".equals(option)) {

                Query q = session.createQuery("UPDATE author SET email = :email WHERE id = :id");
                q.setParameter("email", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("fax".equals(option)) {

                Query q = session.createQuery("UPDATE author SET fax = :fax WHERE id = :id");
                q.setParameter("fax", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            }
            t.commit();

        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }
    
    
    public void deleteAuthor(int id){
    
            Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Query q = session.createQuery("DELETE FROM author WHERE id = :id");
            q.setParameter("id", id);
            int result = q.executeUpdate();
            t.commit();
            System.out.println("Result "+result);

        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }

}
