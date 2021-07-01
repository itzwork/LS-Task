package com.example.ls_task;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//import io.realm.RealmObject;
//import io.realm.annotations.PrimaryKey;
//import io.realm.annotations.Required;

//class Employee extends RealmObject {
class Employee {
    private int id;
    private String name;
    private String companyId;
    private String phone;
    private String address;
    private String picture;
    private Date dateStart;
    private String employeeType;
    private static Employee instance = null;
    ArrayList<Employee> employees = new ArrayList<Employee>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDateStart() {
        return Calendar.getInstance().getTime();
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, String companyId, String phone, String address, String picture, String employeeType) {
        this.id=id;
        this.name=name;
        this.address = address;
        this.phone=phone;
        this.companyId = companyId;
        this.picture = picture;
//        this.dateStart = dateStart;
        this.employeeType = employeeType;
    }

    public Employee(int id, String firstName, String lastName, String phone, String address, String roll) {
        this.id=id;
        this.name=firstName+ " "+ lastName;
        this.address = address;
        this.phone=phone;
        this.companyId = roll;
//        this.picture = picture;
        this.dateStart = getDateStart();
//        this.employeeType = employeeType;
    }

    public Employee() {
//        getInstance();
        setEmployee();
    }

    public void setEmployee() {
        employees.add(new Employee(employees.size()+1,"Roni Bonim","60d86c3ea3a4ab476bd79431","05099983765","Rothschild 22 Tel Aviv","", "watching"));
        employees.add(new Employee(employees.size()+1,"Alex Shvarts","60d86df5a3a4ab476bd79433","05099983765","Trumpeldor 1 Petach Tikva","", "admin"));
        employees.add(new Employee(employees.size()+1,"Roni Bonim","60d86c3ea3a4ab476bd79431","05099983765","Rothschild 22 Tel Aviv","", "watching"));
        employees.add(new Employee(employees.size()+1,"Alex Shvarts","60d86df5a3a4ab476bd79433","05099983765","Trumpeldor 1 Petach Tikva","", "admin"));
        employees.add(new Employee(employees.size()+1,"Roni Bonim","60d86c3ea3a4ab476bd79431","05099983765","Rothschild 22 Tel Aviv","", "watching"));
        employees.add(new Employee(employees.size()+1,"Alex Shvarts","60d86df5a3a4ab476bd79433","05099983765","Trumpeldor 1 Petach Tikva","", "admin"));
    }

    public static Employee getInstance() {
        if(instance == null) {
            instance = new Employee();
        }
        return instance;
    }
}
