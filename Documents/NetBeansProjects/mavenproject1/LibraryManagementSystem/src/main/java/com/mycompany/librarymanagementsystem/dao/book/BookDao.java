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

}
