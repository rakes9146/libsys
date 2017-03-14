package com.mycompany.librarymanagementsystem.dao.publisher;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import com.mycompany.librarymanagementsystem.beans.publisher.Publisher;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Transaction;

public class PublisherDao {

    public void save(Publisher publisher) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(publisher);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }
        }

    }

    public List<Publisher> getPublisherList() {

        List<Publisher> ls = new ArrayList<Publisher>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(Publisher.class);
            t.commit();
            ls = c.list();
        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
        return ls;
    }

    public List<String> getPublisherName() {

        ArrayList<String> ar = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            ar = (ArrayList<String>) session.createSQLQuery("SELECT name FROM publisher").list();
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ar;
    }
}
