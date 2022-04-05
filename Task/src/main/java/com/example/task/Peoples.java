package com.example.task;

import javax.persistence.*;

@Entity
@Table (name="people")
public class Peoples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String mid_name;
    public Peoples() {
    }

    public Peoples(String name, String surname, String mid_name) {
        this.name = name;
        this.surname = surname;
        this.mid_name = mid_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMid_name() {
        return mid_name;
    }

    public void setMid_name(String mid_name) {
        this.mid_name = mid_name;
    }
}
