package com.mycompany.librarymanagementsystem.dao.book;

import com.mycompany.librarymanagementsystem.beans.book.BookTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookTransactionDao {

    public void addTransaction(BookTransaction bd) {

        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(bd);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

}
