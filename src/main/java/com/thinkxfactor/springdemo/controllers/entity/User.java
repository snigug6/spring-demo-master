package com.thinkxfactor.springdemo.controllers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User
 {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "age")
    private int age;

    
    


public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

public long getId() {
        return id;
    }

    public void setId(long string) {
        this.id = string;
    }

public String getName()
{

    return name;
}

public void setName(String name)
{

    this.name = name;

}
}


