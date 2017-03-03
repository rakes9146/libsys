package com.mycompany.librarymanagementsystem.dao.member;

import com.mycompany.librarymanagementsystem.beans.member.Member;
import org.hibernate.Session;
import hibernate.util.HibernateUtil;
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
            e.printStackTrace();
        }
    }

}
