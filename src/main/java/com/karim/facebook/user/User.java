package com.karim.facebook.user;

import com.karim.facebook.post.Post;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String firstname ;

    private String surname ;

    private String email;

    private String password;

    private Date date;

    private String gender ;

    //Constructor
    public User(){

    }

    public User(String firstname, String surname, String email, String password, Date date, String gender) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.date = date;
        this.gender = gender;
    }

    //Setter And Getter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    //toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                '}';
    }

}
