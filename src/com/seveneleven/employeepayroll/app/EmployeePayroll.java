package com.seveneleven.employeepayroll.app;

import java.util.Scanner;

import com.seveneleven.employeepayroll.exception.ValidationException;
import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.UserAccount;
import com.seveneleven.employeepayroll.service.AuthenticationService;
import com.seveneleven.employeepayroll.service.EmployeeService;
import com.seveneleven.employeepayroll.session.Session;
import com.seveneleven.employeepayroll.validation.Validator;

public class EmployeePayroll {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        EmployeeService employeeService = new EmployeeService();
        AuthenticationService authService = new AuthenticationService();

        while(true){

            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Register Employee");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

            case 1:

                try {

                    System.out.print("Employee ID (EMP-XXXX): ");
                    String empId = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    Validator.validateEmpId(empId);
                    Validator.validateEmail(email);
                    Validator.validatePhone(phone);

                    UserAccount account = new UserAccount(username,password);

                    Employee emp = new Employee(empId,name,email,phone,account);
                    
                    System.out.println(emp);

                    employeeService.registerEmployee(emp);

                } catch (ValidationException e) {

                    System.out.println("Validation Error: "+e.getMessage());

                }

                break;

            case 2:

                Session session = authService.login();

                if(session != null && !session.isExpired()){
                    System.out.println("Session active and valid");
                }
                else{
                    System.out.println("Login failed");
                }

                break;

            case 3:

                System.out.println("Exiting System...");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice");

            }

        }
	}
}
