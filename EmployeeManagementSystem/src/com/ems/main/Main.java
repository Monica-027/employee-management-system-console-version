package com.ems.main;

import java.util.Scanner;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        int choice = 0; //taking 0 temp

        while(choice != 7){
            System.out.println("\n Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Delete All");
            System.out.println("7. Exit");
            System.out.print("Enter your choice of Operation: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Eid:");
                    int eid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Dept:");
                    String dept = sc.nextLine();
                    

                    System.out.println("Enter Salary:");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee emp = new Employee(eid, name, dept, salary); //object of employee is created with the data provided by user
                    service.addEmp(emp); // usig service addEmp() to add emp & internally it'll call repo's addEmployee() to add the emp in the list
                    break;
                case 2:
                    service.viewEmployees();
                    break;
                case 3:
                    System.out.println("Enter eid: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    service.searchEmp(searchId);
                    break;
                case 4:
                    System.out.println("Enter eid you want to update");
                    int updatedID = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Enter Name");
                    String updatedName = sc.nextLine();
                    
                    System.out.println("Enter Dept");
                    String updatedDept = sc.nextLine();

                    System.out.println("Enter Salary");
                    double updatedSalary = sc.nextDouble();
                    sc.nextLine();

                    Employee updatedEmp = new Employee(updatedID, updatedName, updatedDept, updatedSalary);
                    service.updateEmployee(updatedEmp);
                    break;

                case 5:
                System.out.println("Enter eid of employee you want to Delete:");
                int deleteId = sc.nextInt();
                service.deleteById(deleteId);
                    break;
                case 6:
                    service.deleteAll();
                    break;
                case 7:
                    System.out.println("Exiting Program......");
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }

        }
        sc.close();
    }

}
