package com.ems.model;

public class Employee {
    //fields
    private int eid;
    private String name;
    private String dept;
    private double salary;

    //Constructor
    public Employee(int eid, String name, String dept, double salary){
        this.eid = eid;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    //getters & setters
    public void setEid(int eid) {
        this.eid = eid;
    }
    public int getEid() {
        return eid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    // //overrriden toString()
    // @Override
    // public String toString() {
    //     return "Emp [Eid: " + eid + ",Name: " + name + ", Dept: " + dept + ",Salary: " + salary + "]";
    // }

    public void display(){
        System.out.println("Id: " + eid + " ,Name:" + name + ",Dept: " + dept + " ,Salary: " + salary);
    }

}
