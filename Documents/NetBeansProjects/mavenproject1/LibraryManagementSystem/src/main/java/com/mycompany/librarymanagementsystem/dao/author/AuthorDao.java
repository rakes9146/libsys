package com.mycompany.librarymanagementsystem.dao.author;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

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
}
