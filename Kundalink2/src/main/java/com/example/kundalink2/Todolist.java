package com.example.kundalink2;
import java.time.LocalDate;

public class Todolist {
int Id;
String Name;
String Gender;
String Email;
LocalDate Birth_date;
String Photo;
double Mark;
String Comments;
    public Todolist(int Id, String Name, LocalDate date, String comments)
    {
        this.Id=Id;
        this.Name=Name;

        this.Birth_date=date;
        this.Comments=comments;

    }
    public Todolist()
    {
        this.Id=0;
        this.Name="not defined";

        this.Birth_date=null;
        this.Comments="not defined";
    }



    public String getName() {
        return Name;
    }

    public LocalDate getBirth_date() {
        return Birth_date;
    }


    public int getId() {
        return Id;
    }

    public String getComments() {
        return Comments;
    }



    public void setName(String name) {
        Name = name;
    }

    public void setBirth_date(LocalDate birth_date) {
        Birth_date = birth_date;
    }

    public void setComments(String comments) {
        Comments = comments;
    }



    public void setId(int id) {
        Id = id;
    }



    @Override
    public String toString() {
        return  Name ;

    }

}
