
package com.test;
import hibernate.util.HibernateUtil;

import org.hibernate.Session;
public class test {
    
    public static void main(String[] args) {
        
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Session Started");
        session.close();
        System.out.println("Session Closed");
               
         
    }
    
}
