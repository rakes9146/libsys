package com.mycompany.librarymanagementsystem.dao.staff;

import com.mycompany.librarymanagementsystem.beans.staff.Staff;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class StaffDao {

    public void save(Staff staff) {

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

}
