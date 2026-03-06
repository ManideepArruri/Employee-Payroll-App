package com.seveneleven.employeepayroll.app;

import java.util.Scanner;

import com.seveneleven.employeepayroll.download.DownloadToken;
import com.seveneleven.employeepayroll.exception.ValidationException;
import com.seveneleven.employeepayroll.file.FileService;
import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.UserAccount;
import com.seveneleven.employeepayroll.payroll.PayrollService;
import com.seveneleven.employeepayroll.payroll.Payslip;
import com.seveneleven.employeepayroll.persistence.DataStore;
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
            System.out.println("3 Generate Payslip");
            System.out.println("4 Print / Download Payslip");
            System.out.println("5. Exit");

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

                System.out.print("Enter Username: ");
                String user = sc.nextLine();

                Employee emp = DataStore.employees.get(user);

                if(emp == null){
                    System.out.println("Employee not found.");
                    break;
                }

                System.out.print("Month: ");
                String month = sc.nextLine();

                System.out.print("Basic Salary: ");
                double basic = sc.nextDouble();

                System.out.print("HRA: ");
                double hra = sc.nextDouble();

                System.out.print("DA: ");
                double da = sc.nextDouble();

                System.out.print("Allowances: ");
                double allowances = sc.nextDouble();
                sc.nextLine();

                PayrollService payroll = new PayrollService();

                Payslip payslip = payroll.generatePayslip(emp,month,basic,hra,da,allowances);

                System.out.println(payslip);

            break;
            case 4:

            	System.out.println("\n=== PAYSLIP DOWNLOAD ===");

            	Payslip original = new Payslip(
            	        "EMP-1010",
            	        "John David",
            	        "January 2026",
            	        48500
            	);

            	System.out.println("\nOriginal Payslip:");
            	System.out.println(original);

            	try{

            	    Payslip cloned = (Payslip) original.clone();

            	    if(original.equals(cloned)){
            	        System.out.println("Verified: Download copy is equal to original.");
            	    }

            	    System.out.println("Original hashcode : "+original.hashCode());
            	    System.out.println("Cloned hashcode : "+cloned.hashCode());

            	    DownloadToken token = new DownloadToken();

            	    if(token.isExpired()){
            	        System.out.println("Download token expired.");
            	        break;
            	    }

            	    FileService fs = new FileService();

            	    String txt = fs.savePayslipAsText(cloned);
            	    String pdf = fs.savePayslipAsPdf(cloned);

            	    System.out.println("\nPayslip Download Successful");
            	    System.out.println("Saved as text file : "+txt);
            	    System.out.println("Saved as PDF file : "+pdf);

            	    System.out.println("\n--- Printed Payslip ---");
            	    System.out.println(cloned);

            	}
            	catch(Exception e){

            	    System.out.println("Error during payslip download.");

            	}

            	break;
            case 5:

                System.out.println("Exiting System...");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice");

            }

        }
	}
}
