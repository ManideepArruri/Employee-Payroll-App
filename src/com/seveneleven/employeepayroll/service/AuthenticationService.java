package com.seveneleven.employeepayroll.service;

import java.util.Scanner;

import com.seveneleven.employeepayroll.model.User;
import com.seveneleven.employeepayroll.persistence.DataStore;
import com.seveneleven.employeepayroll.session.Session;

public class AuthenticationService {
	private int maxAttempts = 3;

    public Session login(){

        Scanner sc = new Scanner(System.in);

        int attempts = 0;

        while(attempts < maxAttempts){

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = DataStore.users.get(username);

            if(user != null && user.authenticate(username,password)){

                System.out.println("Login Successful!");
                System.out.println("Role: " + user.getRole());

                return new Session(username);

            }

            attempts++;
            System.out.println("Invalid credentials. Attempts left: "+(maxAttempts-attempts));

        }
        sc.close();
        return null;
    }
}
