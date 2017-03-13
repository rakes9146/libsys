package com.mycompany.librarymanagementsystem.dao.staff;

import com.mycompany.librarymanagementsystem.beans.book.Book;
import com.mycompany.librarymanagementsystem.beans.member.Member;
import com.mycompany.librarymanagementsystem.beans.staff.Staff;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
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

    public List<Staff> getAuthorList() {

        List<Staff> ls = new ArrayList<Staff>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Criteria c = session.createCriteria(Staff.class);
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
