package com.example.task.dao;

import com.example.task.models.Peoples;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.task.util.HibernateSessionFactoryUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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
    public List<Peoples> findByPassport () {
        Query query= HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("select distinct on (p.passport) p.id,p.name,p.surname,p.mid_name,p.passport,p.address,p.family_status,p.number,p.organization,p.post,p.work_time,p.credit_sum,p.credit_id from People p").addEntity(Peoples.class);
        List<Peoples> peoples= (List<Peoples>) query.getResultList();
        return peoples;
    }
    public List<Peoples> findByAll (String name,String surname,String mid_name,String number, String passport) {
        Query query= HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("select * from People p where p.name=:name and p.surname=:surname and p.mid_name=:mid_name and p.number=:number and p.passport=:passport").addEntity(Peoples.class).setParameter("name",name).setParameter("surname",surname).setParameter("mid_name",mid_name).setParameter("number",number).setParameter("passport",passport);
        List<Peoples> peoples= (List<Peoples>) query.getResultList();
        return peoples;
    }

    public List<Peoples> findByFIO (String name,String surname,String mid_name) {
        Query query= HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("select * from People p where p.name=:name and p.surname=:surname and p.mid_name=:mid_name").addEntity(Peoples.class).setParameter("name",name).setParameter("surname",surname).setParameter("mid_name",mid_name);
        List<Peoples> peoples= (List<Peoples>) query.getResultList();
        return peoples;
    }

    public List<Peoples> findByOnePass (String passport) {
        Query query= HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("select * from People p where p.passport=:passport").addEntity(Peoples.class).setParameter("passport",passport);
        List<Peoples> peoples= (List<Peoples>) query.getResultList();
        return peoples;
    }
    public List<Peoples> findByPhone (String number) {
        Query query= HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery("select * from People p where p.number=:number").addEntity(Peoples.class).setParameter("number",number);
        List<Peoples> peoples= (List<Peoples>) query.getResultList();
        return peoples;
    }

    public List<Peoples> findAll(){
        List<Peoples> peoples=(List<Peoples>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Peoples").list();
        return peoples;
    }
}
