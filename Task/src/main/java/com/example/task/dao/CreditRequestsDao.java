package com.example.task.dao;

import com.example.task.models.CreditRequests;
import com.example.task.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditRequestsDao {

    public CreditRequests findById (int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CreditRequests.class, id);
    }

    public void save(CreditRequests CreditRequests) {;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CreditRequests);
        tx1.commit();
        session.close();
    }

    public void update(CreditRequests CreditRequests) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(CreditRequests);
        tx1.commit();
        session.close();
    }

    public void delete(CreditRequests CreditRequests) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(CreditRequests);
        tx1.commit();
        session.close();
    }

    public CreditRequests findByName (String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CreditRequests.class, name);
    }

    public List<CreditRequests> findAll(){
        List<CreditRequests> creditRequests=(List<CreditRequests>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From CreditRequests ").list();
        return creditRequests;
    }
}
