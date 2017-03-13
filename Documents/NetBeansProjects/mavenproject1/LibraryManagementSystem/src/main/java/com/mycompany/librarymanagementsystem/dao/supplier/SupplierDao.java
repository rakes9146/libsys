package com.mycompany.librarymanagementsystem.dao.supplier;

import com.mycompany.librarymanagementsystem.beans.author.AuthorDetails;
import com.mycompany.librarymanagementsystem.beans.supplier.Supplier;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
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
    
       public List<Supplier> getSupplierList() {

        List<Supplier> ls = new ArrayList<Supplier>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(Supplier.class);
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
}
