package com.mycompany.mavenrestfullab23;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radya
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    private String id;
    private String name;
    private String phone;
    private String position;
    private float salary;
    public Employee() {
    }

    public Employee(String id, String name, String phone, String position, float salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    } 

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public float getSalary() {
        return salary;
    }
    
    
    @Override
    public String toString()
    {
        return this.id+" "+this.name+" "+this.phone+" "+this.position+" "+this.salary;
    }
    
}
