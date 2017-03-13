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

}
