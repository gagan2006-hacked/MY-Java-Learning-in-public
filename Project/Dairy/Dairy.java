package com.Project.Dairy;

import java.sql.Date;

public class Dairy {
    private int id ;
    private String tittle;
    private String data;
    private Date date_of;

    public Dairy(int id, String tittle, String data, Date date_of) {
        this.id = id;
        this.tittle = tittle;
        this.data = data;
        this.date_of = date_of;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDate_of(Date date_of) {
        this.date_of = date_of;
    }

    public String getTittle() {
        return tittle;
    }

    public String getData() {
        return data;
    }

    public Date getDate_of() {
        return date_of;
    }
}
