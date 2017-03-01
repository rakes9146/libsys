package com.mycompany.librarymanagementsystem.dao.category;

import com.mycompany.librarymanagementsystem.beans.category.Category;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class CategoryDao {

    public void save(Category category) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.commit();
            }
            e.printStackTrace();
        }

    }
}
