package com.mycompany.librarymanagementsystem.dao.supplier;

import com.mycompany.librarymanagementsystem.beans.supplier.Supplier;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class SupplierDao {

    public void save(Supplier supplier) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(supplier);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
