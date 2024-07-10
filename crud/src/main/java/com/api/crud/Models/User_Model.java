package com.api.crud.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user")
public class User_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "firs_name")
    private String firs_name;
    @Column(name = "last_name")
    private String last_name;

    @Column(name = "gmail")
    private String gmail;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }



}
