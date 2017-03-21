package com.mycompany.librarymanagementsystem.dao.supplier;

import com.mycompany.librarymanagementsystem.beans.supplier.Supplier;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        } finally {
            session.close();
            session.flush();
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

    public List<String> getSupplierNames() {

        ArrayList<String> ar = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            ar = (ArrayList<String>) session.createSQLQuery("SELECT name FROM supplier").list();
            t.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ar;
    }

    public void update(String updated_value, int id, String option) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();

            if ("address".equals(option)) {

                Query q = session.createQuery("UPDATE supplier SET adddress = :adddress WHERE id = :id");
                q.setParameter("adddress", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("mobno".equals(option)) {

                Query q = session.createQuery("UPDATE supplier SET phone = :phone WHERE id = :id");
                q.setParameter("phone", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("email".equals(option)) {

                Query q = session.createQuery("UPDATE supplier SET email = :email WHERE id = :id");
                q.setParameter("email", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("fax".equals(option)) {

                Query q = session.createQuery("UPDATE publisher SET fax = :fax WHERE id = :id");
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

    public void deleteAuthor(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Query q = session.createQuery("DELETE FROM supplier WHERE id = :id");
            q.setParameter("id", id);
            int result = q.executeUpdate();
            t.commit();
            System.out.println("Result " + result);

        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }
}
