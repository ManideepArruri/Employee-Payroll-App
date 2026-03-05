package com.seveneleven.employeeregistration.app;

import java.io.IOException;
import java.util.Scanner;

import com.seveneleven.employeeregistration.exception.ValidationException;
import com.seveneleven.employeeregistration.model.Employee;
import com.seveneleven.employeeregistration.model.UserAccount;
import com.seveneleven.employeeregistration.validation.Validator;

public class EmployeeRegistrationApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 1: EMPLOYEE REGISTRATION ===");

        try {

            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine();

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            // Validation
            Validator.validateEmpId(empId);
            Validator.validateEmail(email);
            Validator.validatePhone(phone);

            // Object creation
            UserAccount account = new UserAccount(username, password);

            Employee employee = new Employee(empId, name, email, phone, account);

            // Save to file
            employee.persist();

            System.out.println("\nEmployee Registered Successfully:\n");
            System.out.println(employee);

            System.out.println("\nData persisted in file: employee_data.txt");

        }
        catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }

        sc.close();

	}

}
