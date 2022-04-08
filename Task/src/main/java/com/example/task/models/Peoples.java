package com.example.task.models;

import com.example.task.models.CreditRequests;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="people")
public class Peoples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String mid_name;
    private String passport;
    private String family_status;
    private String address;
    private String number;
    private String organization;
    private String post;
    private Integer work_time;
    private Integer credit_sum;

//    @OneToMany(mappedBy = "people",cascade = CascadeType.ALL,orphanRemoval = true)
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "credit_id",referencedColumnName = "id")
    private CreditRequests creditRequests;
//    private List<CreditRequests> requests;

    public Peoples() {
    }

    public Peoples(String name, String surname, String mid_name, String passport, String family_status, String address, String number, String organization, String post, Integer work_time, Integer credit_sum) {
        this.name = name;
        this.surname = surname;
        this.mid_name = mid_name;
        this.passport = passport;
        this.family_status = family_status;
        this.address = address;
        this.number = number;
        this.organization = organization;
        this.post = post;
        this.work_time = work_time;
        this.credit_sum = credit_sum;
    }

    public Integer getId(){
        return id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFamily_status() {
        return family_status;
    }

    public void setFamily_status(String family_status) {
        this.family_status = family_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getWork_time() {
        return work_time;
    }

    public void setWork_time(Integer work_time) {
        this.work_time = work_time;
    }

    public Integer getCredit_sum() {
        return credit_sum;
    }

    public void setCredit_sum(Integer credit_sum) {
        this.credit_sum = credit_sum;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public CreditRequests getCreditRequests() {
        return creditRequests;
    }
    public String getCreditStat(){
        CreditRequests creditRequests=getCreditRequests();
        if(creditRequests.getDecision())
        {
            return "Одобрено";
        }
        else
            return "Отклонено";
    }

    public void setCreditRequests(CreditRequests CreditRequests) {
        this.creditRequests = CreditRequests;
    }
}
