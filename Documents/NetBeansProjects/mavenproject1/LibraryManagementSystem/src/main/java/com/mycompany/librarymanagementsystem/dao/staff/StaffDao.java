package com.mycompany.librarymanagementsystem.dao.staff;

import com.mycompany.librarymanagementsystem.beans.staff.addstaff;
//import com.mycompany.librarymanagementsystem.beans.staff.Staff;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class StaffDao {

    public void save(addstaff staff) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.save(staff);
            t.commit();
        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<addstaff> getAuthorList() {

        List<addstaff> ls = new ArrayList<addstaff>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(addstaff.class);
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

    public void update(String updated_value, int id, String option) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();

            if ("address".equals(option)) {

                Query q = session.createQuery("UPDATE addstaff SET address = :address WHERE id = :id");
                q.setParameter("address", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("mobno".equals(option)) {

                Query q = session.createQuery("UPDATE addstaff SET mobile_number = :phone WHERE id = :id");
                q.setParameter("phone", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("email".equals(option)) {

                Query q = session.createQuery("UPDATE addstaff SET email = :email WHERE id = :id");
                q.setParameter("email", updated_value);
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

    public void delete(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Query q = session.createQuery("DELETE FROM addstaff WHERE id = :id");
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
