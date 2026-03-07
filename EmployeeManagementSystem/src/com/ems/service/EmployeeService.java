package com.ems.service;

import java.util.List;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

public class EmployeeService {

    //ref var of repo
    private EmployeeRepository repository;

    //constructor
    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    //add the employee
    public void addEmp(Employee emp){
        if(repository.findById(emp.getEid()) != null){
            System.out.println("Employee with EID: " + emp.getEid() + " already exists");
        }else{
            repository.addEmployee(emp);
            System.out.println("Employee with EID: " + emp.getEid() + " Added Successfully");
        }
       
    }

    //view all employee data at once
    public void viewEmployees(){
        List<Employee> emps = repository.getAllEmployees();

        if(emps.isEmpty()){
            System.out.println("No Emp data exists");
            for (Employee employee : emps) {
                employee.display();
            }
        }else{
            System.out.println("----Employee list----");
             for(Employee e : emps){
                System.out.println(e);
            }
            System.out.println("----------------");
        } 
    }

    //search emp
    public void searchEmp(int eid){
       Employee emp = repository.findById(eid);
       
       if(emp != null){
        System.out.println("Employee With "+ eid + " found");
        System.out.println(emp);
       }else{
        System.out.println("Employee with id " + eid + " not found.");
       }
    }

    public void updateEmployee(Employee emp){
       boolean updated =  repository.updateEmployee(emp);

       if(updated){
        System.out.println("Employee with eid: " + emp.getEid() +" updated successfully");
       }else{
        System.out.println("Employee not found");
       }
    }

    public void deleteById(int eid){
       boolean deleted =  repository.deleteEmployee(eid);

       if(deleted){
        System.out.println("Employee with id: " + eid +" deleted successfully");
       }else{
        System.out.println("Employee not found");
       }
    }

    //(Added bms)
    public void deleteAll(){
        List<Employee> employees = repository.getAllEmployees();
        if(!employees.isEmpty()){
            repository.deleteAllEmployees(); //Mistake : didn't call the method from repo here
            System.out.println("All employee deleted");
        }else{
            System.out.println("Employees not deleted");
        }
    }

}
