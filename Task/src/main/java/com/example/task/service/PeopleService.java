package com.example.task.service;

import com.example.task.dao.PeopleDao;
import com.example.task.Peoples;

import java.util.List;

public class PeopleService {

    public PeopleDao peopleDao=new PeopleDao();

    public PeopleService(){

    }

    public Peoples findPeople(int id)
    {
        return peopleDao.findById(id);
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
