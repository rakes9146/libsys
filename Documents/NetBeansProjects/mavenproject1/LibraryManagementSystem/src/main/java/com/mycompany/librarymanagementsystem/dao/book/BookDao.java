package com.mycompany.librarymanagementsystem.dao.book;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import com.mycompany.librarymanagementsystem.beans.book.Book;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {

    public BookDao() {
    }

    public void saveBook(Book bk) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(bk);
            t.commit();

        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        }
    }

    public List<Book> getBookList() {

        List<Book> ls = new ArrayList<Book>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(Book.class);
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

    public boolean isAvailable(int id) {

        boolean flag = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Query q = session.createQuery("SELECT member_id FROM member WHERE member_id = :book_id");
            q.setParameter("book_id", id);
            int i = q.getMaxResults();
            System.out.println("The Maximum Value is " + i);

        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
        return flag;
    }

    public void updateBooks(int id, String update_type, String update_value) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            if ("quantity".equals(update_type)) {

                Query query = session.createQuery("UPDATE book SET book_qunatity = :quantity WHERE book_id = :id");
                query.setParameter("quantity", update_value);
                query.setParameter("id", id);
                int r = query.executeUpdate();
                transaction.commit();
                System.out.println("Result " + r);

            } else if ("price".equals(update_type)) {

                Query query = session.createQuery("UPDATE book SET book_price = :book_price WHERE book_id = :book_id");
                query.setParameter("book_price", Float.parseFloat(update_value));
                query.setParameter("book_id", id);
                int r = query.executeUpdate();
                transaction.commit();
                System.out.println("Result " + r);

            } else if ("isbn".equals(update_type)) {

                Query query = session.createQuery("UPDATE book SET book_isbn = :book_isbn WHERE book_id = :book_id");
                query.setParameter("book_isbn", update_value);
                query.setParameter("book_id", id);
                int r = query.executeUpdate();
                transaction.commit();
                System.out.println("Result " + r);
            } else if ("description".equals(update_type)) {

                Query query = session.createQuery("UPDATE book SET book_descrription = :book_description WHERE book_id = :book_id");
                query.setParameter("book_description", update_value);
                query.setParameter("book_id", id);
                int r = query.executeUpdate();
                transaction.commit();
                System.out.println("Result " + r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Execute");
    }

    public void delete(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM book WHERE book_id = :id");
            query.setParameter("id", id);
            int r = query.executeUpdate();
            transaction.commit();
            System.out.println("Result " + r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExist(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        boolean flag = false;
        try {
            t = session.beginTransaction();

            Query query = session.createQuery("SELECT count(*) FROM book WHERE book_id = :id");
            query.setParameter("id", id);

            Long result = (Long) query.uniqueResult();
            System.out.println("Result is " + result);
            if (result > 0) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
