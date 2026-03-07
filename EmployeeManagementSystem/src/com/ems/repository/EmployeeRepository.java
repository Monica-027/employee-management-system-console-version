package com.ems.repository;

import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;

public class EmployeeRepository {
    //we want  list to store employee data/act as database
    private List<Employee> employees = new ArrayList<>();

    //INSERT
    public void addEmployee(Employee emp){
        employees.add(emp); //using lists add method to add emp 1 by 1
    }

    //read All Employees
    public List<Employee> getAllEmployees(){
        return employees; //returns the list of all employees
    }

    //read one employee data
    public Employee findById(int eid){
    //using loop to loop throught the emps list
        for(Employee emp: employees){
            //if emp with specified id found
            if(emp.getEid() == eid){
                return emp; //print it
            }
        }
        return null; //else print null
    }

    //update employee data
    public boolean updateEmployee(Employee updatedEmp){
        for(Employee emp: employees){
            if(emp.getEid() == updatedEmp.getEid()){
                //get updated Name & set it to the real name
                emp.setName(updatedEmp.getName());
                emp.setDept(updatedEmp.getDept());
                emp.setSalary(updatedEmp.getSalary());
                return true; //if empid is same update & return true
            }
        }
        return false; //else, return false
    }

    //delete employee by id
    public boolean deleteEmployee(int eid){
        for(Employee emp: employees){
            if(emp.getEid() == eid){
                //remove the emp from the emps list
                employees.remove(emp);
                return true; //if emp is found & deleted
            }else{
                return false;
            }
        }
        return false;
    }

    //delete all(Added bms)
    public void deleteAllEmployees(){
        employees.clear();
    }
    

}
