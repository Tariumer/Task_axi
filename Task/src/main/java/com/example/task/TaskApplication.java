package com.example.task;

import com.example.task.Peoples;
import com.example.task.service.PeopleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) throws SQLException
    {

        PeopleService peopleService=new PeopleService();;
        SpringApplication.run(TaskApplication.class, args);
    }
}
