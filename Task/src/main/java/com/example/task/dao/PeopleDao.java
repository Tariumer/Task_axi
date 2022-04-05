package com.example.task.dao;

import com.example.task.Peoples;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.task.util.HibernateSessionFactoryUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleDao {

    public Peoples findById (int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Peoples.class, id);
    }

    public void save(Peoples people) {;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(people);
        tx1.commit();
        session.close();
    }

    public void update(Peoples people) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(people);
        tx1.commit();
        session.close();
    }

    public void delete(Peoples people) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(people);
        tx1.commit();
        session.close();
    }

    public Peoples findByName (String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Peoples.class, name);
    }

    public List<Peoples> findAll(){
        List<Peoples> peoples=(List<Peoples>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Peoples").list();
        return peoples;
    }
}
