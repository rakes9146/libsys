package com.mycompany.librarymanagementsystem.dao.category;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import com.mycompany.librarymanagementsystem.beans.category.Category;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
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

    public List<Category> getCategoryList() {

        List<Category> ls = new ArrayList<Category>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(Category.class);
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

    public List<String> getCategoryNames() {

        ArrayList<String> ar = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            ar = (ArrayList<String>) session.createSQLQuery("SELECT name FROM CATEGORY").list();
            t.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ar;
    }
}
