package com.kunda.kundatest1;

import java.util.Date;

public class List {
    String title;
    String contant;
    int id;
    boolean completed;

    Date date;
    public List() {
        new List("missing","missing",-1);
    }

    public List(String title, String contant) {
        this.title = title;
        this.contant = contant;
        this.id = -1;
        completed=false;
    }

    public List(String title, String contant, int id) {
        this.title = title;
        this.contant = contant;
        this.id = id;
        completed=false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean finished(){
        if (completed){
            return false;
        }
        completed=true;
        return true;
    }
    public boolean unfinished(){
        if (completed){
            completed=false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return title+"";
    }
}
