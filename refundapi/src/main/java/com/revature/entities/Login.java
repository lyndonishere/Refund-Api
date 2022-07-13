package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {


    // NOTE: Just realized need to add a role to them

    // we need fields to represent the data in our database
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String user_password;
    private String user_role;

    // we need an empty constructor for Hibernate
    public Login(){}
 
    // having this partial constructor will help us to make sure we don't accidentally set a bad id
    public Login(String username, String user_password, String user_role) {
        this.username = username;
        this.user_password = user_password;
        this.user_role = user_role;
    }

    // this constructor will allow our code to full create Login objects from pre-existing data in our table
    public Login(int id, String username, String user_password, String user_role) {
        this.id = id;
        this.username = username;
        this.user_password = user_password;
        this.user_role = user_role;
    }

    // feel free to use the vsc source action... option to use this
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "Login [id=" + id + ", user_password=" + user_password + ", user_role=" + user_role + ", username="
                + username + "]";
    }

}