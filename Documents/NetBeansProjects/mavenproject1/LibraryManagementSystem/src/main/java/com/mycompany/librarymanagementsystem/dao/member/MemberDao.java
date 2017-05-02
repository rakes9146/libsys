package com.mycompany.librarymanagementsystem.dao.member;

import com.mycompany.librarymanagementsystem.beans.member.Member;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class MemberDao {

    public void save(Member member) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {

            t = session.beginTransaction();
            session.persist(member);
            t.commit();
        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
        }
    }

    public List<Member> memberList() {
        List<Member> l = new ArrayList<Member>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {

            t = session.beginTransaction();
            Criteria c = session.createCriteria(Member.class);
            t.commit();
            l = c.list();

        } catch (Exception e) {
            if (t == null) {
                t.rollback();
            }
            e.printStackTrace();
        }

        return l;

    }

    public boolean isAvailable(int id) {

        boolean flag = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            Query q = session.createQuery("SELECT member_id FROM member WHERE member_id = :member_id");
            int i = q.getMaxResults();
            q.setParameter("member_id", id);

            System.out.println("The Maximum Value is " + i);
            if (i > 0) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {

            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isExist(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        boolean flag = false;
        try {
            t = session.beginTransaction();

            Query query = session.createQuery("SELECT count(*) FROM member WHERE member_id = :member_id");
            query.setParameter("member_id", id);

            Long result = (Long) query.uniqueResult();
            t.commit();
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
    
    
    public void update(String updated_value, int id, String option) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();

            if ("address".equals(option)) {

                Query q = session.createQuery("UPDATE member SET address = :address WHERE id = :id");
                q.setParameter("address", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("mobno".equals(option)) {

                Query q = session.createQuery("UPDATE member SET mobile_number = :phone WHERE id = :id");
                q.setParameter("phone", updated_value);
                q.setParameter("id", id);
                int r = q.executeUpdate();
                System.out.println(r);

            } else if ("email".equals(option)) {

                Query q = session.createQuery("UPDATE member SET email = :email WHERE id = :id");
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
            Query q = session.createQuery("DELETE FROM member WHERE id = :id");
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
