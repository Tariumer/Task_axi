package com.example.task.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "decisions")
public class CreditRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Boolean decision;
    private Integer time;
    private Integer credit;
    private Date date;
    private Boolean status;


    public CreditRequests(Boolean decision, Integer time, Integer credit, Boolean status) {
        this.decision = decision;
        this.time = time;
        this.credit = credit;
        this.status = status;
    }

    public CreditRequests() {
    }

    public CreditRequests(Boolean decision) {
        this.decision = decision;
    }

    public int getId() {
        return id;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
