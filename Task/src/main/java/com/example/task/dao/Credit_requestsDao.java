package com.example.task.dao;

import com.example.task.Credit_requests;
import com.example.task.Peoples;
import com.example.task.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Credit_requestsDao {

    public Credit_requests findById (int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Credit_requests.class, id);
    }

    public void save(Credit_requests credit_requests) {;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(credit_requests);
        tx1.commit();
        session.close();
    }

    public void update(Credit_requests credit_requests) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(credit_requests);
        tx1.commit();
        session.close();
    }

    public void delete(Credit_requests credit_requests) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(credit_requests);
        tx1.commit();
        session.close();
    }

    public Credit_requests findByName (String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Credit_requests.class, name);
    }

    public List<Credit_requests> findAll(){
        List<Credit_requests> credit_requests=(List<Credit_requests>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Credit_requests ").list();
        return credit_requests;
    }
}
