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
}
