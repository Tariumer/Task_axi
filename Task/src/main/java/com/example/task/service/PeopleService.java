package com.example.task.service;

import com.example.task.dao.PeopleDao;
import com.example.task.models.Peoples;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    public PeopleDao peopleDao=new PeopleDao();

    public PeopleService(){

    }

    public Peoples findPeople(int id)
    {
        return peopleDao.findById(id);
    }

    public List<Peoples> findPeoplePass()
    {
        return peopleDao.findByPassport();
    }

    public List<Peoples> findByAllParam(String name,String surname,String mid_name,String number,String passport)
    {
        return peopleDao.findByAll(name,surname,mid_name,number,passport);
    }

    public List<Peoples> findPeopleByFIO(String name,String surname,String mid_name)
    {
        return peopleDao.findByFIO(name,surname,mid_name);
    }
    public List<Peoples> findPeopleByPassport(String passport)
    {
        return peopleDao.findByOnePass(passport);
    }
    public List<Peoples> findPeopleByPhone(String number)
    {
        return peopleDao.findByPhone(number);
    }

    public void savePeople(Peoples people)
    {
        peopleDao.save(people);
    }

    public void deletePeople(Peoples people)
    {
        peopleDao.delete(people);
    }

    public void updatePeople(Peoples people)
    {
        peopleDao.update(people);
    }

    public List<Peoples> findAllPeoples()
    {
        return peopleDao.findAll();
    }
}
