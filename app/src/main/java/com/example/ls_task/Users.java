package com.example.ls_task;

import java.util.ArrayList;

public class Users {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    ArrayList<Users> users = new ArrayList<Users>();
    private static Users instance = null;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Users(int id, String firstName, String lastName, String email, String password) {
        this.id=id;
        this.firstName=firstName;
        this.lastName = lastName;
        this.email=email;
        this.password = password;

    }

    public Users() {
//        getInstance();
        setUsers();
    }

    public void setUsers() {
        users.add(new Users(users.size()+1,"Dan","Choen","123456@gmail.com","Gm123456"));
        users.add(new Users(users.size()+1,"Yael","Levi","12345678@gmail.com","Gm12345678"));
    }

    public static Users getInstance() {
        if(instance == null) {
            instance = new Users();
        }
        return instance;
    }
}
