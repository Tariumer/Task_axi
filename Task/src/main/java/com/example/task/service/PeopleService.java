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
